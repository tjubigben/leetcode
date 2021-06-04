package com.company;

import com.company.common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * 解题思路：
 * 题目不是很难，和字符串相加（大数相加）类似的原理（大数相加，我一般会有一个对齐的过程）。有三个需要注意的地方。
 * 1. 循环停止条件，l1 != null || l2 != null；
 * 2. 计算过程中，注意判空；
 * 3. 注意最后一位是否有进位。
 * wangkai
 * 2021/6/1
 **/

public class AddTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode thisList = new ListNode();
            ListNode head = thisList;
            int sum = 0;
            int flag = 0;
            while (l1 != null || l2 != null) {
                int x = l1 != null ? l1.getVal() : 0;
                int y = l2 != null ? l2.getVal() : 0;
                sum = x + y + flag;
                if (l1 != null) {
                    l1 = l1.getNext();
                }
                if (l2 != null) {
                    l2 = l2.getNext();
                }
                ListNode thisNode = new ListNode(sum % 10, null);
                thisList.setNext(thisNode);
                thisList = thisNode;
                flag = sum / 10;
            }
            if (flag != 0) {
                thisList.setNext(new ListNode(flag, null));
            }
            return head.getNext();
        }
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(5, null);
        ListNode l12 = new ListNode(3, l11);
        ListNode l13 = new ListNode(4, l12);
        ListNode l1 = new ListNode(9, l13);
        ListNode l2 = new ListNode(8, l13);

        Solution solution = new AddTwoNumbers().new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.getVal() + "->");
            result = result.getNext();
        }
    }
}
