package com.company.array;

import java.util.*;

/**
 * 编号：697
 * 题目描述：给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 链接：https://leetcode.cn/problems/degree-of-an-array
 *
 * @author bigben
 */
public class DegreeOfAnArray697 {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,3,1};
//        int[] nums = {6,6,6,7,7};
        int[] nums = {2, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, DegreeArray> degreeArrayHashMap = new HashMap<>(32);
//        DegreeArray numOfMaxDegree = new DegreeArray(nums[0],0,0,1);
        List<Integer> numsOfMaxDegree = new ArrayList<>();
        int maxDegree = 1;
        for (int i = 0; i < nums.length; i++) {
            DegreeArray degreeArrayExisted = degreeArrayHashMap.get(nums[i]);
            if (Objects.isNull(degreeArrayExisted)) {
                DegreeArray degreeArray = new DegreeArray(nums[i], i, i, 1);
                degreeArrayHashMap.put(nums[i], degreeArray);
            } else {
                ++degreeArrayExisted.degree;
                degreeArrayExisted.end = i;
                degreeArrayHashMap.put(nums[i], degreeArrayExisted);
                if (degreeArrayExisted.degree > maxDegree) {
                    maxDegree = degreeArrayExisted.degree;
                    numsOfMaxDegree.clear();
                    numsOfMaxDegree.add(nums[i]);
                }
                if (degreeArrayExisted.degree == maxDegree) {
                    numsOfMaxDegree.add(nums[i]);
                }
            }
        }
        if (numsOfMaxDegree.isEmpty()) {
            return 1;
        }
        int shortLength = nums.length;
        for (int numOfMaxDegree : numsOfMaxDegree) {
            DegreeArray degreeArray = degreeArrayHashMap.get(numOfMaxDegree);
            int lengthOfThisDegree = degreeArray.end - degreeArray.begin + 1;
            if (lengthOfThisDegree < shortLength) {
                shortLength = lengthOfThisDegree;
            }
        }
        return shortLength;
    }

    static class DegreeArray {
        public int arrayNum;
        public int begin;
        public int end;
        public int degree;

        public DegreeArray(int arrayNum, int begin, int end, int degree) {
            this.arrayNum = arrayNum;
            this.begin = begin;
            this.end = end;
            this.degree = degree;
        }
    }
}
