package com.marvel.basic.java.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序：
 *  1. 代码实现逻辑采用递归技巧
 *  2. 两个有序的区间合并时采取的方式是各拿一个，然后进行排序
 */
public class MergeSort {
    //归并排序算法
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    //递归调用函数
    public static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return ;    //终止递归
        }
        int q = p + (r-p)/2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        //合并两部分数组
        merge(a, p, q, r);
    }

    /**合并数组两部分**/
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断子数组中那个有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        //将子数组中剩余数据都拷贝到临时数组中
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        //将临时数组中的数据拷贝回数组a[p->r]中
        for (i=0; i<=r-p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 9, 10, 5, 23, 39, 65, 2, 5, 98, 8};
        System.out.println(Arrays.toString(array));
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
