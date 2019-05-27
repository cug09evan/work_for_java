package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue;

import com.alibaba.fastjson.JSON;
import java.util.Stack;

/**
 * 用递归函数和栈操作逆序一个栈
 */
public class RecursionStack {

    /**
     * 递归获取栈的最后一个元素
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        //判断递归结束条件:当栈为空时，返回pop出来的元素
        int element = stack.pop();
        if (stack.empty()) {
            return element;
        } else {
            int last = getAndRemoveLastElement(stack);
            //将其它条件下的元素重新压入栈
            stack.push(element);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        //递归结束条件
        if (stack.empty()) {
            return;
        } else {
            int element = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(element);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(JSON.toJSONString(stack));
        RecursionStack.reverse(stack);
        System.out.println(JSON.toJSONString(stack));
        System.out.println(stack.peek());
    }
}
