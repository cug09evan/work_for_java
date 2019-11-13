package com.marvel.geektime.algorithm.linklist;

import java.util.Scanner;

/**
 * 基于LinkedList完成LRU最近最少使用算法
 */
public class LRUBaseLinkedList<T> {
    //默认链表容量
    private final static int DEFAULT_CAPACITY = 10;
    //头结点
    private SNode<T> headNode;
    //链表长度
    private int length;
    //链表容量
    private int capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUBaseLinkedList(int capacity) {
        this.headNode = new SNode<T>();
        this.length = 0;
        this.capacity = capacity;
    }

    //获取查找到元素的前一个节点
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }

        return null;
    }

    public void add(T data) {
        //查看在链表中是否已存在该节点
        SNode preNode = findPreNode(data);
        //若链表中存在该节点，则删除该节点，然后从头部插入
        if (preNode != null) {
            deleteElementOptim(preNode);
            //从头部添加数据
            insertElementAtBegin(data);
        } else {
            //若链表中没有该数据，则直接从头部插入
            if (length >= this.capacity) {
                //删除尾结点
                deleteElementAtEnd();
            }

            insertElementAtBegin(data);
        }
    }

    //在头部添加元素
    private void insertElementAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    //删除尾部节点
    private void deleteElementAtEnd() {
        SNode ptr = headNode;
        if (headNode.getNext() == null) {
            return;
        }

        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    //删除链表中的preNode节点的下一个节点
    private void deleteElementOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * 设置LRU算法中的元素结构
     **/
    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
