package com.company;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * 解题思路：
 * 注意判断边界问题
 * wangkai
 * 2021/6/10
 **/
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            int sum = 0;
            while (x != 0){
                // 判断是否超界
                if (sum < Integer.MIN_VALUE / 10  || sum > Integer.MAX_VALUE / 10){
                    return 0;
                }
                sum = sum * 10 + x % 10;
                x = x / 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int x = 123;
        Solution solution = new ReverseInteger().new Solution();
        int result = solution.reverse(x);
        System.out.println(result);
    }
}
