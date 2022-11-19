package com.bigben.string;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 题目：125
 * 题目描述：
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-palindrome
 *
 * @author bigben
 */
public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, aa canal: Panama";
        Boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char character : lowerCase.toCharArray()) {
            if ((character >= '0' && character <= '9') || (character >= 'a' && character <= 'z')) {
                sb.append(character);
            }
        }

        String temp = sb.toString();
        if (temp.isEmpty()) {
            return true;
        }

        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
