package com.marvel.basic.java.algorithm.sort;

import java.util.Arrays;

/**
 * 简单选择排序算法：通过n-i次关键字间比较，从中选出关键字最大的记录，并和第i个记录交换
 */
public class SimpleSelectionSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //简单排序算法实现
    public static void selectSort(int[] array) {
        int length = array.length;
        for (int i=0; i<length-1; i++) {
            //定义一个记录最大值和记录下标的变量
            int max = array[i];
            int index = i;
            for (int j=i+1; j<length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            if (index != i) {
                swap(array, i, index);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 9, 10, 5, 23, 39, 65, 2, 5, 98};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
