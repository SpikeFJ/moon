package org.fj;

/**
 * 希尔排序
 *
 * @author spike
 */
public class Shell {
    int currentSize;
    private Integer[] array = new Integer[0];

    public void insert(Integer value) {
        array[currentSize++] = value;
        shitUp(currentSize);
    }

    public int remove() {
        Integer root = array[0];
        Integer lastNode = array[currentSize];
        shitDown(currentSize);

        return root;
    }

    private void shitUp(int index) {
        //1.将该节点缓存到tmp，减少移动
        //2.比较上级节点和本节点大小，如果上级节点小于本节点，交换。
        Integer tmp = array[index];

        int parentIndex = (index - 1) / 2;
        while (array[parentIndex] < array[index]) {
            array[index] = array[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        array[index] = tmp;
    }

    private void shitDown(int index) {
        Integer root = array[index];
        Integer largeIndex;

        while (index < currentSize / 2) {
            Integer leftIndex = 2 * index + 1;
            Integer rightIndex = 2 * index + 2;
            if (rightIndex < currentSize && array[leftIndex] < array[rightIndex]) {
                largeIndex = rightIndex;
            } else {
                largeIndex = leftIndex;
            }

            if (root >= array[largeIndex]) {
                break;
            }
            array[index] = array[largeIndex];
            index = largeIndex;
        }

        array[index] = root;
    }
}
