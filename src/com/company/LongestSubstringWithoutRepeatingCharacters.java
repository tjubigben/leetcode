package com.company;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * 解题思路：
 * 利用滑动窗口的思路，设置左右两个指针。如从位置k开始，至位置rk结束，没有重复字母。下一次，我们则需要从位置（k+1）开始，但其中
 * 从（k+1）至rk这一段是没有重复字母的，因此我们只需要从位置rk开始，向右开始移动指针，同时左指针（代码中用i来表示的左指针）也向
 * 右边移动一位。
 * 此外，我们需要用一个数据结构来保存不重复的字符，我们使用的是set。
 *
 * wangkai
 * 2021/6/7
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int mixLen = 0;
            // hashset 记录已经出现的字符
            Set<Character> strSet = new HashSet<>();
            //相当于右指针
            int startPoint = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                // 左指针向右移动一位，并移除重复字符
                if (i != 0){
                    strSet.remove(s.charAt(i-1));
                }
                // 若字符不重复，则一直向右移动右指针
                while (startPoint < n && !strSet.contains(s.charAt(startPoint))){
                    strSet.add(s.charAt(startPoint));
                    ++ startPoint;
                }
                mixLen = max(mixLen, startPoint - i);
            }
            return mixLen;
        }
    }

    public static void main(String[] args) {
        String s = "bb";
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int resule = solution.lengthOfLongestSubstring(s);
        System.out.println(resule);
    }
}
