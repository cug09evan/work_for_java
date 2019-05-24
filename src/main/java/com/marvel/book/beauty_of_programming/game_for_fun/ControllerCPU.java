package com.marvel.book.beauty_of_programming.game_for_fun;

/**
 * CPU的占用率固定在50%，为一条直线；
 * CPU的占用率为一条直线，但是具体占用率由命令行参数决定（参数范围1~100）；
 * CPU的占用率状态是一个正弦曲线
 */
public class ControllerCPU {
    public static void main(String[] args) {
        while (true) {
            for (int i=0; i<10640000; i++) {
                try {
                    Thread.sleep(10);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
