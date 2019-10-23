package com.marvel.book.introduction_to_algorithms.chapter15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 钢条切割例子
 */
public class DynamicProgramming {
    //钢条分成长度以及对应的价格：1-1,2-5.。。。
    public static int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    //采用递归的方式解决钢条切割问题
    public static int solution_recuice(int length) {
        if (length <= 0)
            return 0;
        int result = Integer.MIN_VALUE;
        for (int i=1; i<=length; i++) {
            result = Math.max(result, prices[i-1] + solution_recuice(length - i));
        }

        return result;
    }

    //采用自顶向下的动态规划算法解决钢条切割问题
    public static int mem_cut_rod(int n) {
        int[] dp = new int[n+1];    //辅助数组
        Arrays.fill(dp, Integer.MIN_VALUE);
        return mem_cut_rod_aux(n, dp);
    }

    private static int mem_cut_rod_aux(int n, int[] dp) {
        if (dp[n] >= 0)
            return dp[n];

        int max = Integer.MIN_VALUE;
        if (n <= 0) {
            max = 0;
        } else {
            for (int i=1; i<=n; i++) {
                max = Math.max(max, prices[i-1] + mem_cut_rod_aux(n-i, dp));
            }
        }
        dp[n] = max;
        return max;
    }

    //采用自底向上算法求解钢条切割问题
    public static int bottom_up_cut_rod(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int j=1; j<=n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i=1; i<=j; i++) {
                max = Math.max(max, prices[i-1] + dp[j-i]);
            }
            dp[j] = max;
        }

        return dp[n];
    }

    //bottom-up-cut-rob的扩展版本，它对于长度为j 的钢条不仅计算最大收益值Rj, 还保存最优解对应的第一段钢条的切割长度Sj：
    private static int[] path;
    public static int extend_bottom_up_cut_rod(int n) {
        int[] dp = new int[n+1];
        path = new int[n+1];
        dp[0] = 0;

        for (int j=1; j<=n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i=1; i<=j; i++) {
                if (max < (prices[i-1] + dp[j-i])) {
                    max = prices[i-1] + dp[j-i];
                    path[j] = i;
                }
            }
            dp[j] = max;
        }

        return dp[n];
    }

    public static ArrayList<Integer> getAcutSolution(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (n > 0) {
            result.add(path[n]);
            n -= path[n];
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i=1; i<=prices.length; i++) {
            System.out.println("递归算法----长度为：" + i + "的最大收益为：" + solution_recuice(i));
            System.out.println("动态规划算法自顶向下----长度为：" + i + "的最大收益为：" + mem_cut_rod(i));
            System.out.println("动态规划算法自底向上----长度为：" + i + "的最大收益为：" + bottom_up_cut_rod(i));

            System.out.println("--------" + extend_bottom_up_cut_rod(7));
            System.out.println(getAcutSolution(7));
        }
    }
}
