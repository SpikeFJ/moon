package org.fj;

/**
 * 优先级队列
 *
 * @author spike
 */
public class PriorityQ {

    private final int maxSize;
    private int[] elements;
    private int elementNum;


    public PriorityQ(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
    }

    public void insert(int value) {
        if (elementNum == 0) {
            elements[elementNum++] = value;
        } else {
            //插入排序
            int i;
            for (i = elementNum - 1; i >= 0; i--) {

                if (elements[i] > value) {
                    elements[i + 1] = elements[i];
                } else {
                    break;
                }
            }
            elements[i] = value;
            elementNum++;
        }
    }

    public int remove(int value) {
        return elements[elementNum--];

    }

    public void insertA(int value) {
        if (elementNum == 0) {
            elements[elementNum++] = value;
        } else {
            //插入排序
            int i;
            for (i = elementNum - 1; i >= 0; i--) {

                if (elements[i] > value) {
                    elements[i + 1] = elements[i];
                } else {
                    break;
                }
            }
            elements[i] = value;
            elementNum++;
        }
    }


}
