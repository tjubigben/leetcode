package com.bigben.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 编号：448
 * 题目描述：给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n]
 * 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 *
 * @author bigben
 */
public class FindAllNumbersDisappearedInArray448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        disappearedNumbers.forEach(System.out::print);

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int[] tempResult = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            tempResult[num - 1] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (tempResult[i] != 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
