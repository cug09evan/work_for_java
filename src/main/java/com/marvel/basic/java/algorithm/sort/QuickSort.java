package com.marvel.basic.java.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：
 *  采用分治的思想，递归的技巧
 */
public class QuickSort {

    public static void quickSort(int[] array, int size) {
        quickSortInternally(array, 0, size-1);
    }

    private static void quickSortInternally(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(array, p, r) ;

        quickSortInternally(array, p, q-1);
        quickSortInternally(array, q+1, r);
    }

    //获取快排中的分区点
    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j=p; j<r; ++j) {
            if (array[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j] = tmp;
                }
            }
        }

        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
//        int[] array = {12, 9, 10, 5, 23, 39, 65, 2, 5, 98, 8};
        int[] array = {12, 9, 10};
        System.out.println(Arrays.toString(array));
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
