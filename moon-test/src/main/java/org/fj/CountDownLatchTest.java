package org.fj;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    CountDownLatch boss = new CountDownLatch(1);
    CountDownLatch work = new CountDownLatch(5);

    public static void main(String[] args) {

    }

    public  void testTime() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    boss.await();

                    System.out.println("---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    work.countDown();
                }

            }).start();
        }

        long start = System.currentTimeMillis();
        boss.countDown();
        work.await();

        System.out.println(System.currentTimeMillis()-start);
    }
}
