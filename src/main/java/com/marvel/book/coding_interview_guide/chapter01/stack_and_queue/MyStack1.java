package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue;

import java.util.Stack;

/**
 * 问题：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素操作
 * 要求
 *  1. pop、push、getMin操作时间复杂度都是O(1)
 *  2、设计栈类型可以使用现成的栈结构
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 压栈数据
     * @param element 压入栈的元素
     */
    public void push(int element) {
        if (this.stackMin.isEmpty()) {
            stackMin.push(element);
        } else if (element <= this.getMin()) {
            stackMin.push(element);
        }

        this.stackData.push(element);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }

        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }

        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(1);

        System.out.println(String.format("min=%s, pop=%s", stack.getMin(), stack.pop()));
        System.out.println(String.format("min=%s, pop=%s", stack.getMin(), stack.pop()));
        System.out.println(String.format("min=%s, pop=%s", stack.getMin(), stack.pop()));
        System.out.println(String.format("min=%s, pop=%s", stack.getMin(), stack.pop()));
        System.out.println(String.format("min=%s, pop=%s", stack.getMin(), stack.pop()));
    }
}
