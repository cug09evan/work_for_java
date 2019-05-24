package com.marvel.book.beauty_of_programming.game_for_fun;

/**
 * 中国象棋问题：
 * 中国象棋中，将帅相隔遥远，并且不能照面，假设棋盘上只有将和帅两字，如下图所示（A表示将，
 * B表示帅）：A、B二子被限制在己方3 x 3的格子里运动，每一步，A、b分别可以横向或纵向移动一
 * 格，但不能沿对角线移动。另外，A不能面对B，也就是说，A和B不能处于同一纵向直线上，请写出
 * 一个程序，输出A、B所有合法的位置。要求代码中只能使用一个字节存储变量。
 *
 * 解法：
 * 将和帅走的位置都抽象成九宫格，这样，当将所在的位置为1， 那么帅能走的位置就不能是1,4,7，即所在位置与3取模的值不能相等
 */
public class ChineseChess {
    public static void main(String[] args) {
//        new ChineseChess().chessMethodForNoLimit();
        new ChineseChess().chessMethodForAnotherDoubleCircle();
        new ChineseChess().chessMethodForOneByte();
    }

    /**
     * 正常算法
     */
    private void chessMethodForNoLimit() {
        for (int i=1; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                if (i%3 != j%3)
                    System.out.println(String.format("A=%s, B=%s", i, j));
            }
        }
    }

    /**
     * 只使用一个字节的存储算法，由于java
     * 本质就是用一个字节实现了双层循环，验证如方法chessMethodForAnotherDoubleCircle
     */
    private void chessMethodForOneByte() {
        byte i  =81;
        while (i-- != 0) {
            if (i/9%3 == i%9%3) {
                continue;
            }
            System.out.println(String.format("A=%s, B=%s", (i/9+1), (i%9+1)));
        }
    }

    /**
     * 验证方法chessMethodForOneByte的含义的方法
     */
    private void chessMethodForAnotherDoubleCircle() {
        int i=81;
        while (i-- > 0) {
            System.out.print(" " + i/9 + "-" + i%9);
        }
    }
}
