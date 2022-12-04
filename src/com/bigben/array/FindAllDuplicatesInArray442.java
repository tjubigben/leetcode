package com.bigben.array;


import java.util.*;

/**
 * 题目编号：442
 * 题目描述：给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * 链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array
 * @author bigben
 */
public class FindAllDuplicatesInArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Map<Integer,Integer> numToCountMap = new HashMap<>();
        for (int num : nums){
            int countOfNum = Objects.isNull(numToCountMap.get(num))?0:numToCountMap.get(num);
            if (countOfNum ==1){
                result.add(num);
            }
            numToCountMap.put(num, ++countOfNum);
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray442 findAllDuplicatesInArray442 = new FindAllDuplicatesInArray442();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findAllDuplicatesInArray442.findDuplicates(nums);
        result.forEach(System.out::print);

    }
}
