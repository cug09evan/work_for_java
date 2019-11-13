package com.marvel.geektime.algorithm.queue;

public class ArrayQueue {
    private String[] items;
    private int size = 0;
    //队列头下标，队列尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int size) {
        items = new String[size];
        this.size = size;
    }

    public boolean enqueue(String item) {
        if (tail == size) {
            System.out.println("the queue is full");
            return false;
        }

        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println("the queue is empty");
            return null;
        }

        return items[head++];
    }
}
