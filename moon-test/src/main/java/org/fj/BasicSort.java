package org.fj;

import java.util.Arrays;
import java.util.Random;

/**
 * @author spike
 */
public class BasicSort {

    Random random = new Random();

    public static void main(String[] args) {
        BasicSort at = new BasicSort();
        at.init(10);

        at.quickSort();
        System.out.println();
        System.out.print("排序后：");
        Arrays.stream(at.value).forEach(x -> {
            System.out.print(x + " ");
        });
    }

    Integer[] value = new Integer[0];

    private void init(int capacity) {
        value = new Integer[capacity];

        for (int i = 0; i < value.length; i++) {
            value[i] = random.nextInt(100);
        }


        System.out.print("排序前：");

        Arrays.stream(value).forEach(x -> {
            System.out.print(x + " ");
        });
    }

    void bubbleSort() {

        //endIndex:每一轮比较结束的位置
        for (int endIndex = value.length - 1; endIndex > 1; endIndex--) {
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                if (value[startIndex] > value[startIndex + 1]) {
                    swap(startIndex, startIndex + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {

        int temp = value[one];
        value[one] = value[two];
        value[two] = temp;
    }

    void selectSort() {
        //startIndex:每一轮比较的起始位置，最后一个元素不需要
        for (int startIndex = 0; startIndex < value.length - 1; startIndex++) {

            //minIndex：每一轮的最小值，默认为这一轮的起始位置
            int minIndex = startIndex;

            //比较时从该轮的第二个位置比较，因为第一个位置保存到最小值
            for (int i = startIndex + 1; i < value.length; i++) {
                if (value[i] < value[minIndex]) {
                    minIndex = i;
                }
            }

            swap(startIndex, minIndex);
        }
    }

    void insertSort() {

        //假设标志是序号1，因为序号0前面没有元素
        for (int startIndex = 1; startIndex < value.length; startIndex++) {

            //保存标志位元素，腾出位置给需要移动的元素
            Integer tmp = value[startIndex];

            int in = startIndex;
            while (in > 0 && value[in - 1] > tmp) {
                value[in] = value[in - 1];
                in--;
            }
            value[in] = tmp;

        }
    }

    void mergeSort() {
        int[] a = {23, 47, 81, 95};
        int[] b = {7, 14, 39, 55, 62, 74};

        int[] c = new int[a.length + b.length];

        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        while (aIndex < a.length - 1 && bIndex < b.length - 1) {
            if (a[aIndex] < b[bIndex]) {
                c[cIndex++] = a[aIndex++];
            } else {
                c[cIndex++] = b[bIndex++];
            }
        }

        while (aIndex < a.length - 1) {
            c[cIndex++] = a[aIndex++];
        }

        while (bIndex < b.length - 1) {
            c[cIndex++] = b[bIndex++];
        }

    }

    void shellSort() {
        //1. 获取最初的h值，该值（是在不大于数组长度的前提下的）最大值
        int h = 1;
        while (h <= value.length / 3) {
            h = h * 3 + 1;
        }

        int inner;
        int outter;
        int tmp;

        //2.写出整体结构，间隔序列逐渐减少直至为1
        while (h > 0) {
            for (outter = h; outter < value.length; outter++) {
                tmp = value[outter];
                inner = outter;

                while (inner > h - 1 && value[inner - h] >= tmp) {
                    value[inner] = value[inner - h];
                    inner -= h;
                }
                value[inner] = tmp;
            }

            h = (h - 1) / 3;
        }


    }


    void shellSort1() {
        //1. 获取最初的h值，该值（是在不大于数组长度的前提下的）最大值
        int h = 1;
        while (h <= value.length / 3) {
            h = h * 3 + 1;
        }
        int tmp;
        //2.写出整体结构，间隔序列逐渐减少直至为1
        while (h > 0) {

            //i:默认是0直至h，
            // 第一轮比较0，h，2h,3h....
            // 第二轮比较1,1+h,1+2h,2+2h
            for (int i = 0; i < h; i++) {

                for (int j = i + h; j < value.length; j += h) {
                    tmp = value[j];

                    while (j - h >= 0 && value[j - h] > tmp) {
                        value[j] = value[j - h];
                        j -= h;
                    }

                    value[j] = tmp;
                }
            }

            h = (h - 1) / 3;
        }
    }

    /**
     * 划分
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            //leftPtr定位到一个大于pivot的值为止
            while (leftPtr < right && value[++leftPtr] < pivot)
                ;
            //leftPtr定位到一个大于pivot的值为止
            while (right > left && value[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }

        }
        return rightPtr;
    }


    void quickSort() {
        recQuickSort(0, value.length - 1);
    }

    void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = value[right];
            int patition = partitionIt1(left, right, pivot);

            recQuickSort(left, patition - 1);
            recQuickSort(patition + 1, right);
        }
    }




    int partitionIt1(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;//因为选择了最右端元素作为pivot，所以排除最后一个元素

        while (true) {
            while (value[++leftPtr] < pivot)//①
                ;
            while (rightPtr > 0 && value[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return rightPtr;
    }

    void recQuickSort2(int left, int right) {
        int pivot = medianOf3(left, right);
        int patition = partitionIt2(left, right, pivot);

        recQuickSort(left, patition - 1);
        recQuickSort(patition + 1, right);
    }


    private int medianOf3(int left, int right) {
        int center = (right + left) / 2;
        if (value[left] > value[center]) {
            swap(left, center);
        }
        if (value[left] > value[right]) {
            swap(left, right);
        }
        if (value[center] > value[right]) {
            swap(center, right);
        }
        swap(center, right - 1);//将枢纽放到最后端
        return value[right - 1];//返回枢纽
    }

    int partitionIt2(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;//因为选择了最右端元素作为pivot，所以排除最后一个元素

        while (true) {
            while (value[++leftPtr] < pivot)//①
                ;
            while (value[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return rightPtr;
    }

}
