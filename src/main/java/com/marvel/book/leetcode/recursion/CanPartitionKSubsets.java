package com.marvel.book.leetcode.recursion;

import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 注意:
 *      1 <= k <= len(nums) <= 16
 *      0 < nums[i] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartitionKSubsets {
    /**
     * 分析：
     *      1. 判断一个数组能否被分，首先需要看集合总和与被分个数能否整除，如果不能整除，那么肯定就不能分
     *      2. 如果能整除，那么需要考虑是否存在和都相等的情况
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = sum(nums);
        if(nums.length==0 || k==0 || totalSum % k != 0) {
            return false;
        }
        int subSum = totalSum / k;
        Arrays.sort(nums);

        if (nums[nums.length-1] > subSum) {
            return false;
        }

        int[] mark = new int[k];
        Arrays.fill(mark, subSum);
        return cal(nums, k, nums.length-1, mark);
    }

    /**
     * 计算是否满足分割成k个子集
     * @param nums 输入的数组
     * @param k     分割成k个子集
     * @param mark  标记某个位置是否使用
     * @return 是否满足
     */
    private boolean cal(int[] nums, int k, int cur, int[] mark) {
        if (cur < 0)
            return true;

        for (int i=0; i<k; i++) {
            if (mark[i] - nums[cur] >= 0) {
                mark[i] -= nums[cur];
                if (cal(nums, k, cur-1, mark)) {
                    return true;
                }
                mark[i] += nums[cur];
            }
        }

        return false;
    }

    public int sum(int[] nums) {
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            total += nums[i];
        }

        return total;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets instance = new CanPartitionKSubsets();
//        int[] nums = new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        int[] nums = new int[]{4,5,3,2,5,5,5,1,5,5,5,5,3,5,5,2};
        System.out.println(instance.canPartitionKSubsets(nums, 13));
    }
}
