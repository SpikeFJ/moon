package org.fj;

/**
 * 栈
 *
 * @author spike
 */
public class Stack {

    private final int maxSize;
    private int[] elements;
    //指向栈顶
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize - 1];
    }

    public void push(int value) {
        elements[++top] = value;
    }

    public int pop(int value) {
        return elements[top--];
    }

    public int peek(int value) {
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize == top + 1;
    }
}
