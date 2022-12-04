package com.bigben.string;

/**
 * 题目描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author bigben
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int minLength = strs[0].length();
        for (String str : strs){
            if (str.length()<minLength){
                minLength = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char chr = strs[0].charAt(i);
            for (String str : strs){
                if (str.charAt(i) != chr){
                    return sb.toString();
                }
            }
            sb.append(chr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();

        String[] res = new String[]{"flower","flower","flower","flower"};
        String s = longestCommonPrefix14.longestCommonPrefix(res);

        System.out.println(s);
    }
}
