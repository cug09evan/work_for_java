package com.marvel.basic.java.algorithm.tree;

/**
 * 堆的特性：
 *      1. 堆是一个完全二叉树，满足完全二叉树的定义
 *      2. 有大顶堆和小顶堆之说：大顶堆即父节点的值大于等于左右子节点；小顶堆即父节点的值小于等于左右子节点
 *      3. 堆的数据存储是建立在数组的基础上。
 */
public class Heap {
    private int[] a;    //数组，从下标1开始存储数据
    private int n;      //堆的容量
    private int count;  //堆已存储数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //堆插入：插入的时候采取的方式是自下而上堆化，即将要插入的元素放入最后的位置，然后与其父节点进行比较，如果大于其父节点则交换，否则停止
    public void insert(int data) {
        if (count >= n) {
            return; //堆已满
        }
        ++count;
        a[count] = data;
        int i=count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            //自下而上的堆化
            swap(a, i, i/2);
            i = i/2;
        }
    }

    //删除堆的顶点元素：删除过后将堆中最后一个元素置于堆顶，然后将该元素与其左右子节点进行比较，最大的子节点与该元素位置互换
    public void removeMax() {
        if (count == 0) {
            return;     //堆中没有元素
        }

        a[1] = a[count];
        --count;
        //自上而下堆化

    }

    //自上而下堆化
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2])
                maxPos = i*2;
            if ((i*2 + 1) <= n && (a[maxPos] < a[i*2+1]))
                maxPos = i*2 + 1;
            if (maxPos == i)
                break;

            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i=n/2; i>=1; --i) {
            heapify(a, n, i);
        }
    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }
}
