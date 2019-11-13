package com.marvel.geektime.algorithm.stack;

public class ArrayStack {
    private String[] items; //栈元素存储介质
    private int count;      //栈元素个数
    private int size;       //栈大小

    //栈初始化
    public ArrayStack(int size) {
        items = new String[size];
        this.size = size;
        this.count = 0;
    }

    //入栈操作
    public boolean push(String item) {
        if (count == size) {
            System.out.println("the stack is full");
            return false;
        }

        items[count] = item;
        count++;

        return true;
    }

    //出栈操作
    public String pop() {
        if (count == 0) {
            System.out.println("the stack is empty");
            return null;
        }

        count--;
        return items[count];
    }

    //打印从栈低到栈顶的元素
    public void printStack() {
        if (count == 0) {
            System.out.println("");
        }

        for (int i=0; i<count-1; i++) {
            System.out.print(items[i] + ", ");
        }
        System.out.println(items[count-1]);
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push("evan");
        stack.push("marvel");
        stack.push("jack");
        stack.push("rose");
        stack.printStack();
        System.out.println(stack.pop());
        stack.printStack();
    }
}
