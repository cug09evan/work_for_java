package com.marvel.basic.java.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法(从大到小)：
 * 方法一：从头开始，找出每个位置最大(最小)的值
 * 方法二：每次和相邻位置比较，交换比较小的数据到末尾
 * 优化：已经排好序的情况下，就不再往后比较
 */
public class BubbleSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //冒泡排序算法实现:此为最易理解的冒泡算法，同时也是效果最不好的冒泡
    public static int[] bubbleSort01(int[] array) {
        int length = array.length;
        for (int i=0; i<length-1; i++) {
            //找出第i个位置最大的数
            for (int j=i+1; j<length; j++) {
                if (array[j] > array[i]) {
                    swap(array, i, j);
                }
            }
        }

        return array;
    }

    //冒泡算法：每次只比较相邻位置的数据
    public static int[] bubbleSort02(int[] array) {
        int length = array.length;
        for (int i=0; i<length-1; i++) {
            for (int j=length-1; j>i; j--) {
                if (array[j] > array[j-1]) {
                    swap(array, j, j-1);
                }
            }
        }

        return array;
    }

    //冒泡算法优化版：若后面的数据已经排好序，则不再继续比较
    public static int[] bubbleSort03(int[] array) {
        //新增一个标志位，如果某次比较中，都没有进行数据交换，则此标志位置为false，退出所有循环
        int length = array.length;
        boolean flag = true;
        for (int i=0; i<length-1 && flag; i++) {
            flag = false;
            for (int j=length-1; j>i; j--) {
                if (array[j] > array[j-1]) {
                    swap(array, j, j-1);
                    flag = true;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {12, 9, 10, 5, 23, 39, 65, 2, 5, 98};
        array = bubbleSort03(array);
        System.out.println(Arrays.toString(array));
    }
}
