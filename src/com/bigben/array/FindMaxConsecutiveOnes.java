package com.bigben.array;

/**
 * 485 <br>
 * 链接：https://leetcode.cn/problems/max-consecutive-ones/ <br>
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * @author bigben
 */
public class FindMaxConsecutiveOnes {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnesLength = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnesLength);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int consecutiveOnesLength = 0;
        int maxConsecutiveOnesLength = 0;
        for (int num : nums) {
            if ((num & 1) > 0) {
                ++consecutiveOnesLength;
            } else {
                if (consecutiveOnesLength > maxConsecutiveOnesLength) {
                    maxConsecutiveOnesLength = consecutiveOnesLength;
                }
                consecutiveOnesLength = 0;
            }
        }
        return Math.max(maxConsecutiveOnesLength, consecutiveOnesLength);
    }
}
