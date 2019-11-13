package com.marvel.geektime.algorithm.linklist;

/**
 * 链表的基本操作算法实现
 * 1. 单链表反转
 * 2. 链表中环的检测
 * 3. 两个有序链表的合并
 * 4. 删除链表倒数第n个节点
 * 5. 求链表的中间节点
 */
public class LinkListOperate {
    private Node head = null;
    /**两种单链表反转方式
     *  1. 带哨兵节点的链表翻转
     *  2. 不带哨兵的链表翻转**/
    /**带哨兵节点的链表翻转**/
    public Node inverseLinkList_head(Node p) {
        //Head为新建的一个头结点
        Node Head = new Node(9999, null);
        // p为原来链表的头结点，现在head指向整个链表
        Head.setNext(p);

        /**将头节点下一个节点保存下来，同时将头结点的next置为null**/
        Node current = p.getNext();
        p.setNext(null);
        Node next = null;

        /**将后面的每个节点都插入以head头为哨兵的链表的第一个位置**/
        while (current != null) {
            next = current.getNext();
            current.setNext(Head.getNext());
            Head.setNext(current);

            current = next;
        }

        return Head;
    }

    /**不带哨兵的链表翻转**/
    public Node inverseLinkList(Node p) {
        Node Head = new Node(Integer.MIN_VALUE, p);

        Node next = null;
        Node current = p.getNext();
        p.setNext(null);
        while (current != null) {
            next = current.getNext();
            current.setNext(Head.getNext());
            Head.setNext(current);
            current = next;
        }

        return Head.getNext();
    }

    /**链表环路检测
     * 思路1：存在环路的特点是链表的某一个节点的next指针一定指向于链表中的某个节点,此思路比较暴力，时间复杂度为O(n^2)
     * 思路2：采用快慢指针的方式，如果是链表，则快慢指针终究有一次会相等
     * **/
    public boolean linkListCircleCheck(Node p) {
        if (p == null) {
            return false;
        }
        /**
         * 思路1的实现：
        //指定当前节点
        Node current = p.getNext();
        Node circleCheckHead = null;
        while (current != null) {
            circleCheckHead = p;
            while (circleCheckHead != current && circleCheckHead != null) {
                circleCheckHead = circleCheckHead.getNext();
            }
            if (circleCheckHead == null) {
                current = current.getNext();
            } else {
                return true;
            }
        }
         */
        /**
         * 思路2：快慢指针的实现方式，时间复杂度则会小的多
         */
        if (p == null || p.getNext() == null) {
            return false;
        }
        Node slow = p.getNext();
        Node fast = p.getNext().getNext();

        while (slow != null && fast != null) {
            slow = slow.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext().getNext();
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 有序链表的合并：这个思路比较简单，新建哨兵节点，比较两个链表值大小，值大的就给到哨兵节点后面
     * tips:算法考虑的是输入，返回和处理方法
     */
    public Node mergeTwoSortedLinkList(Node p, Node q) {
        final Node node = new Node(Integer.MIN_VALUE, null);
        Node current = node;

        while (p != null && q != null) {
            if (p.getData() >= q.getData()) {
                current.setNext(p);
                p = p.getNext();
            } else {
                current.setNext(q);
                q = q.getNext();
            }

            current = current.getNext();
            current.setNext(null);
        }

        if (p == null) {
            node.setNext(q);
        } else if (q == null) {
            node.setNext(p);
        }

        return node;
    }

    /**往链表尾部插入数据**/
    public void insertTail(int data) {
        Node newNode = new Node(data, null);
        //若为空链表，则直接将data赋给头结点
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }

            newNode.setNext(q.getNext());   //这行代码感觉没有什么必要
            q.setNext(newNode);
        }
    }

    //打印链表数据
    public void printLink() {
        if (head == null) {
            System.out.println("null link list...");
        } else {
            Node q = head;
            while (q.getNext() != null) {
                System.out.print(q.getData() + ",");
                q = q.getNext();
            }
            System.out.println(q.getData());
        }
    }

    public static void main(String[] args) {
        LinkListOperate link = new LinkListOperate();
        int data[] = {1, 2, 5, 3, 1};

        for (int elem : data) {
            link.insertTail(elem);
        }
        link.printLink();

        link.head = link.inverseLinkList_head(link.head).getNext();
        link.printLink();

        link.head = link.inverseLinkList(link.head);
        link.printLink();
    }
}
