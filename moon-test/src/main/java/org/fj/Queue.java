package org.fj;

/**
 * 队列
 *
 * @author spike
 */
public class Queue {

    private final int maxSize;
    private int[] elements;
    //实际队列元素个数
    private int elementNum;
    private int head;
    private int tail;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
        head = 0;
        tail = -1;
    }

    public void insert(int value) {
        //当队尾元素达到最大值时，返回初始位置
        if (tail == maxSize - 1) {
            tail = -1;
        }
        elements[++tail] = value;
        elementNum++;
    }

    public int remove(int value) {
        int tmp = elements[head++];
        //当对头元素道道最大值时，返回初始位置
        if (head == maxSize) {
            head = 0;
        }
        elementNum--;
        return tmp;
    }

    public int peek(int value) {
        return elements[head];
    }

    public boolean isEmpty() {
        return elementNum == 0;
    }

    public boolean isFull() {
        return maxSize == elementNum;
    }
}
