package com.marvel.basic.java.algorithm.sort;

/**
 * 二分查找法的实现
 */
public class BinarySearch {
    public static int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    //用递归法实现二分查找法
    public static int bSearch(int[] a, int n, int value) {
        return bSearchInternally(a, 0, n-1, value);
    }

    private static int bSearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return bSearchInternally(a, low, mid-1, value);
        } else {
            return bSearchInternally(a, mid+1, high, value);
        }
    }

    //查找第一个值等于给定值的元素
    public static int firstBSearch(int[] a, int n, int value) {
        int result = binarySearch(a, n, value);
        if (result >= 0) {
            while (result > 0) {
                if (a[result-1] == value) {
                    result--;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 5, 5, 7, 9, 10, 14, 17, 19, 20};
        System.out.println(BinarySearch.binarySearch(array, array.length, 17));
        System.out.println(BinarySearch.bSearch(array, array.length, 19));
        System.out.println(BinarySearch.firstBSearch(array, array.length, 5));
    }
}
