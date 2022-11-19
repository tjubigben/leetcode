package com.bigben.array;

/**
 * 编号：错误的集合
 * 题目描述：集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 链接：https://leetcode.cn/problems/set-mismatch
 *
 * @author bigben
 */
public class SetMismatch645 {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] result = findErrorNums(nums);
        for (int a : result) {
            System.out.println(a);
        }
    }

    public static int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int[] result = new int[2];
        int[] copyNums = new int[length + 1];
        for (int i = 1; i <= nums.length; i++) {
            if (copyNums[nums[i-1]]==0) {
                copyNums[nums[i-1]] = 1;
            } else {
                result[0] = nums[i-1];
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (copyNums[i]==0) {
                result[1] = i;
            }
        }
        return result;
    }
}
