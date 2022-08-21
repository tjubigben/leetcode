package com.company.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 编号：414 第三大数字 <br>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。<br>
 * 链接：{@link https://leetcode.cn/problems/third-maximum-number/}
 *
 * @author bigben
 */
public class ThirdMax414 {

    /**
     * 1. 声明一个长度为3的list，保存最大的三个数字 <br>
     * 2. 声明一个min，保存最小的数字，每次往list中加数值的时候，把最小的抛出来 <br>
     * 3. 遍历数组 <br>
     * 4. 判断list中是否包含这个数字，若包含，进行下一个 <br>
     * 5. list长度若小于3，则将数字加入list，并计算min，进行下一个 <br>
     * 5. 若不包含，与min进行判断，若小于min，进行下一个 <br>
     * 6. 若大于min，则将此数替换list中的min数，并重置min <br>
     *
     * @param nums 传入的数组
     * @return
     */
    public static int thirdMax(int[] nums) {
        List<Integer> maxThreeNumList = new ArrayList<>();
        maxThreeNumList.add(nums[0]);
        int minOfMaxThreeNum = nums[0];
        // 计算最大的三个数字
        for (int num : nums) {
            if (maxThreeNumList.contains(num)) {
                continue;
            }
            if (maxThreeNumList.size()<3){
                maxThreeNumList.add(num);
                maxThreeNumList = maxThreeNumList.stream().sorted().collect(Collectors.toList());
                minOfMaxThreeNum = maxThreeNumList.get(0);
                continue;
            }
            if (num <= minOfMaxThreeNum) {
                continue;
            }
            int index = maxThreeNumList.indexOf(minOfMaxThreeNum);
            maxThreeNumList.set(index, num);
            maxThreeNumList = maxThreeNumList.stream().sorted().collect(Collectors.toList());
            minOfMaxThreeNum = maxThreeNumList.get(0);
        }

        // 返回结果
        if (maxThreeNumList.size()<3){
            maxThreeNumList = maxThreeNumList.stream().sorted().collect(Collectors.toList());
            return maxThreeNumList.get(maxThreeNumList.size()-1);
        }else {
            return minOfMaxThreeNum;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,5,3,5};
        System.out.println(thirdMax(nums));
    }
}
