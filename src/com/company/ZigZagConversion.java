package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * wangkai
 * 2021/6/9
 **/
public class ZigZagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }
            int curRow = 0;
            boolean goingDown = false;
            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) {
                    goingDown = !goingDown;
                }
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder request = new StringBuilder();
            for (StringBuilder row : rows) {
                request.append(row);
            }
            return request.toString();
        }
    }

    public static void main(String[] args) {

    }
}
