package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LC2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode result = head;

        int sum = 0;
        while (cur1 != null || cur2 != null) {
            sum /= 10;
            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            int digit = sum % 10;
            result.next = new ListNode(digit);
            result = result.next;

        }
        if (sum / 10 == 1) {
            result.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        System.out.println(addTwoNumbers(l1, l2).val);
    }
}