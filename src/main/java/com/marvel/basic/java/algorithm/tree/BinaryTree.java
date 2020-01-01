package com.marvel.basic.java.algorithm.tree;

/**
 * 二叉树
 */
public class BinaryTree {
    //根节点
    private Node tree;

    //查找节点
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return null;
    }

    /**
     *  插入节点
     *      1. 看根节点是否为空，若为空，则插入到根节点
     *      2. 若根节点不为空，则比较与根节点数据大小，一直到插入叶子节点的位置
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除节点：
     *      1.此处需要维护三个变量，分别是要删除节点，要删除节点的父节点、要删除节点的子节点，子节点的优先级为，若有左子节点，则为左子节点(当然这种情况目前来看是不存在的)
     *      2.找到要删除的节点p，以及其父节点
     *      3.
     */
    public void delete(int data) {
        Node p = tree;  //p节点指向要删除的节点，初始化指向根节点
        Node pp = null; //pp节点指向p的父节点

        //找到要删除的p节点以及其父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null)
            return;

        //要删除的节点有左右两个叶子节点的情况
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; //将minP的数据替换到p中
            p = minP;
            pp = minPP;
        }

        //要删除的节点是叶子节点或只有一个子节点
        Node child;     //p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //此处是为了解决删除节点过后其子节点的处理
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    //定义二叉树节点的接口
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
