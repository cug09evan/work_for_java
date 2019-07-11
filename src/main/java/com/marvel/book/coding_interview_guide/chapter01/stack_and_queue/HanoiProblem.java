package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue;

/**
 * 解决汉诺塔问题的算法
 */
public class HanoiProblem {

    /**
     * 经典递归算法实现经典汉诺塔问题
     * @param num
     * @param left
     * @param mid
     * @param right
     */
    public static void moveClassic(int num, String left, String mid, String right) {
        //递归首先需要将推出条件设置好
        if (num == 1) {
            System.out.println(String.format("盘 %s 由 %s 移动至 %s", num, left, right));
        } else {
            //先将第n-1个盘移动到mid
            moveClassic(num-1, left, right, mid);
            System.out.println(String.format("盘 %s 由 %s 移动至 %s", num, left, right));
            moveClassic(num-1, mid, left, right);
        }
    }

    public static void main(String[] args) {
        HanoiProblem.moveClassic(3, "left", "mid", "right");
    }
}
