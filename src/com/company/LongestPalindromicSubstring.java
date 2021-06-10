package com.company;


/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * wangkai
 * 2021/6/9
 **/
public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            int lenStr = s.length();
            String subStr = "";
            int maxLen = 1;
            for (int i = 0; i < lenStr; i++) {
                int count = 0;
                int start = i;
                int end = i + 1;
                while (start >= 0 && end < lenStr && s.charAt(start) == s.charAt(end)) {
                    --start;
                    ++end;
                    count = count + 2;
                }
                if (count > maxLen) {
                    subStr = s.substring(start + 1, end);
                    maxLen = count;
                }

                int index = 1;
                int count2 = 1;

                while (index <= i && index < lenStr - i && s.charAt(i - index) == s.charAt(i + index)) {
                    ++index;
                    count2 = count2 + 2;
                }
                if (count2 > maxLen) {
                    subStr = s.substring(i - index + 1, i + index);
                    maxLen = count2;
                }
            }
            return subStr.isEmpty() ? s.substring(0, 1) : subStr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "abc";
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}
