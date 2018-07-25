package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC92 {
    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     * <p>
     * Note: 1 ≤ m ≤ n ≤ length of list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LC92 solution = new LC92();
        ListNode input = ListNode.getLinkedList(1, 2, 3, 4, 5);
        System.out.println(solution.reverseBetween(input, 2, 4));
    }
}
