package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 用一个栈实现另外一个栈的排序
 */
public class SortStack {

    private static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.push(stack.pop());
        while (!stack.empty()) {
            if (stack.peek() >= tempStack.peek()) {
                tempStack.push(stack.pop());
            } else {
                int tempElem = stack.pop();
                while (!tempStack.empty()) {
                    stack.push(tempStack.pop());
                }
                tempStack.push(tempElem);
            }
        }

        while (! tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }

    private static void sortStackByStackOptition(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (! stack.empty()) {
            int element = stack.pop();
            while (!help.empty() && help.peek() < element) {
                stack.push(help.pop());
            }
            help.push(element);
        }
        while (! help.empty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(10);
        stack.push(1);
        stack.push(5);
        stack.push(2);

        System.out.println(JSON.toJSONString(stack));
//        sortStackByStack(stack);
        sortStackByStackOptition(stack);
        System.out.println(JSON.toJSONString(stack));
    }
}
