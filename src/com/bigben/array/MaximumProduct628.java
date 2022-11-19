package com.bigben.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 编号:628 三个数的最大乘积 <br>
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。<br>
 * 链接：{@link https://leetcode.cn/problems/maximum-product-of-three-numbers/}
 *
 * @author bigben
 */
public class MaximumProduct628 {

    /**
     * 非空数组nums中有正数和负数。因此首先需要将数组分成两个不同的数列，分情况考虑。<br>
     * 一、对于只有三个数的非空集合，直接返回三个数字的乘积即可。 <br>
     * 二、对于只有正数，或者只有负数的情况，很方便可以计算最大的乘积（只有正数时，取最大的三个数。只有负数时，取最小的三个数）<br>
     * 三、还有一些其他特殊情况：<br>
     * 1. 负数大于等于两个，正数超过两个： 需要取最小的两个负数的和最大正数乘积 与 最大三个正数乘积 的 较大值 <br>
     * 2. 负数大于等于两个，正数一个：最小的两个负数的和最大正数乘积 <br>
     * 3. 负数小于两个 ：最大三个正数乘积 <br>
     */
    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        List<Integer> positiveNumList = new ArrayList<>();
        int positiveNumListSize = 0;
        List<Integer> negativeNumList = new ArrayList<>();
        int negativeNumListSize = 0;
        for (int num : nums) {
            if (num >= 0) {
                positiveNumList.add(num);
                ++positiveNumListSize;
            } else {
                negativeNumList.add(num);
                ++negativeNumListSize;
            }
        }
        // 排序
        if (!positiveNumList.isEmpty()) {
            positiveNumList = positiveNumList.stream().sorted().collect(Collectors.toList());
        }
        if (!negativeNumList.isEmpty()) {
            negativeNumList = negativeNumList.stream().sorted().collect(Collectors.toList());
        }
        // 计算
        if (!negativeNumList.isEmpty() && positiveNumList.isEmpty()) {
            return negativeNumList.get(negativeNumListSize - 1) * negativeNumList.get(negativeNumListSize - 2) * negativeNumList.get(negativeNumListSize - 3);
        }

        if (negativeNumList.isEmpty() || negativeNumListSize < 2) {
            return positiveNumList.get(positiveNumListSize - 1) * positiveNumList.get(positiveNumListSize - 2) * positiveNumList.get(positiveNumListSize - 3);
        }

//        if (negativeNumListSize >= 2)
        int maxNegativeNumMaximum = negativeNumList.get(0) * negativeNumList.get(1);
        if (positiveNumListSize <= 2) {
            return maxNegativeNumMaximum * positiveNumList.get(positiveNumListSize - 1);
        }
//            if (positiveNumListSize > 2)
        int maxPositionMaximum = positiveNumList.get(positiveNumListSize - 1) * positiveNumList.get(positiveNumListSize - 2) * positiveNumList.get(positiveNumListSize - 3);
        int maxPositionAndNegativeNum = maxNegativeNumMaximum * positiveNumList.get(positiveNumListSize - 1);
        return Math.max(maxPositionAndNegativeNum, maxPositionMaximum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }
}
