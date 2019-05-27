package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue;

import java.util.Stack;

/**
 * 用两个栈实现队列，支持队列的基本操作：add/poll/peek
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int element) {
        stackPush.push(element);
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.empty()) {
            while (! stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue instance = new TwoStackQueue();
        instance.add(1);
        instance.add(2);
        System.out.println(instance.poll());
        instance.add(3);
        System.out.println(instance.poll());
        instance.add(4);
        System.out.println(instance.peek());
    }
}
