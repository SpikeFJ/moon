package org.fj;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印ABC10次
 */
public class PrintAbc {

    public class ThreadTest implements Runnable {
        private ThreadLocal<Integer> value = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                System.out.print("线程【" + Thread.currentThread().getId() + "】设置:" + i);
                value.set(i);
                System.out.println();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程【" + Thread.currentThread().getId() + "】查询:" + value.get());
            }
        }
    }

    private void test0() {
        ThreadTest test = new ThreadTest();
        Thread a = new Thread(test);
        a.start();

        Thread b = new Thread(test);
        b.start();
    }


    public static void main(String[] args) {


        PrintAbc obj = new PrintAbc();
        obj.test0();
//        obj.test2();

    }


    private Lock lockObj = new ReentrantLock();
    private Condition conditionA = lockObj.newCondition();
    private Condition conditionB = lockObj.newCondition();
    private Condition conditionC = lockObj.newCondition();

    /**
     * Lock+Condition
     */
    private void test1() {
        //首先启动C、B,防止A线程调用唤起时，还没有线程在等待信号
        new C().start();
        new B().start();
        new A().start();
    }

    void test2() {
        Object objectA = new Object();
        Object objectB = new Object();
        Object objectC = new Object();

        new ThreadC(objectC, objectA).start();
        new ThreadB(objectB, objectC).start();
        new ThreadA(objectA, objectB).start();
    }

    class A extends Thread {

        @Override
        public void run() {
            lockObj.lock();

            try {
                //线程A 1.打印 2.唤起B 3.阻塞
                for (int i = 0; i < 10; i++) {
                    System.out.println("第" + (i + 1) + "次:--------->");
                    System.out.println("A");
                    conditionB.signal();
                    conditionA.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockObj.unlock();
            }

        }
    }

    class B extends Thread {

        @Override
        public void run() {
            lockObj.lock();
            try {
                //线程B 1.阻塞 2.打印 3.唤起C
                for (int i = 0; i < 10; i++) {
                    conditionB.await();
                    System.out.println("B");
                    conditionC.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockObj.unlock();
            }

        }
    }

    class C extends Thread {

        @Override
        public void run() {

            lockObj.lock();
            try {
                //线程B 1.阻塞 2.打印 3.唤起A
                for (int i = 0; i < 10; i++) {
                    conditionC.await();
                    System.out.println("C");
                    conditionA.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockObj.unlock();
            }

        }
    }

    class ThreadA extends Thread {
        //自身锁
        private Object self;
        //下一个线程需要的锁
        private Object next;

        ThreadA(Object pre, Object next) {
            this.self = pre;
            this.next = next;
        }

        @Override
        public void run() {
            try {
                synchronized (self) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("A");
                        synchronized (next) {
                            next.notify();
                        }
                        self.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadB extends Thread {
        private Object self;
        private Object next;

        ThreadB(Object pre, Object next) {
            this.self = pre;
            this.next = next;
        }

        @Override
        public void run() {
            try {
                synchronized (self) {
                    for (int i = 0; i < 10; i++) {
                        self.wait();
                        System.out.println("B");
                        synchronized (next) {
                            next.notify();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    class ThreadC extends Thread {
        private Object self;
        private Object next;

        ThreadC(Object self, Object next) {
            this.self = self;
            this.next = next;
        }

        @Override
        public void run() {
            try {
                synchronized (self) {
                    for (int i = 0; i < 10; i++) {
                        self.wait();
                        System.out.println("C");
                        synchronized (next) {
                            next.notify();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
