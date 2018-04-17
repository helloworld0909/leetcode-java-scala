package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

import java.util.Arrays;

public class LC19 {
    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null)
                return head.next;
        }
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(0);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(3);
        LC19 solution = new LC19();
        input = solution.removeNthFromEnd(input, 2);
        System.out.println(Arrays.asList(input.val, input.next.val, input.next.next.val));
    }
}
