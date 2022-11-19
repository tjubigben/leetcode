package com.bigben.string;

import com.sun.deploy.util.StringUtils;

/**
 * 题目：520
 * 题目描述：
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大,比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 链接：https://leetcode.cn/problems/detect-capital
 *
 * @author bigben
 */
public class DetectCapital520 {
    public static void main(String[] args) {
        String word = "USA";
        boolean result = detectCapitalUse(word);
        System.out.println(result);
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        // 首字母小写
        if (word.charAt(0) - 'a' >= 0) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) - 'a' < 0) {
                    return false;
                }
            }
            return true;
        }
        // 第二位大写
        if (word.charAt(1) - 'a' < 0) {
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) - 'a' >= 0) {
                    return false;
                }
            }
        } else {
            // 第二位小写
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) - 'a' < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
