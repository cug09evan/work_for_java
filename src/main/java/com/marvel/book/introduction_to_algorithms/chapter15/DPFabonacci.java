package com.marvel.book.introduction_to_algorithms.chapter15;

import java.util.Arrays;

/**
 * 动态规划求解斐波那契数列
 *
 * 斐波那契数列，又称黄金分割数列，指的是这样一个数列：0、1、1、2、3、5、8、13、21、……在数学上，斐波纳契数列以如下被以
 * 递归的方法定义：F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）在现代物理、准晶体结构、化学等领域，斐波纳契数列都有直接的应用
 */
public class DPFabonacci {
    //使用递归算法求解fabonacci数列
    public static int fabonacci_recurse(int i) {
        if (i==0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fabonacci_recurse(i-1) + fabonacci_recurse(i-2);
        }
    }

    //使用动态规划算法求解fabonacci数列:自底向上实现
    public static int fabonacci_dp(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        if (n < 2) {
            return dp[n];
        } else {
            for (int i=2; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fabonacci_recurse(40));
        long fabonacci_recurse = System.currentTimeMillis();
        System.out.println("递归算法耗时：" + (fabonacci_recurse - start));
        System.out.println(fabonacci_dp(40));
        System.out.println("动态规划算法耗时：" + (System.currentTimeMillis() - fabonacci_recurse));
    }
}
