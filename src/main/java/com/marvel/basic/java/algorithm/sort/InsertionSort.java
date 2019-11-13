package com.marvel.basic.java.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：
 *  1. 定义：已排区间与未排区间
 *  2. 开始条件：数组第一个位置为已排区间，其它为未排区间
 *  3. 结束条件：未排区间无元素
 */
public class InsertionSort {

    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i=1; i<n; i++) {
            int value = a[i];
            int j = i - 1;
            //查找插入位置
            for ( ; j>=0; --j) {
                if (a[j] <= value) {
                    break;
                } else {
                    a[j+1] = a[j];  //移动数据
                }
            }

            a[j+1] = value;     //插入数据
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 9, 10, 5, 23, 39, 65, 2, 5, 98};
        InsertionSort.insertionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
