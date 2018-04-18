package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC61 {
    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * Example 2:
     * <p>
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int length = 1;
        ListNode tail = head;
        for (; tail.next != null; tail = tail.next)
            length++;

        int cutPos = length - k % length;
        if (cutPos == 0 || cutPos == length)
            return head;

        ListNode node = head;
        for (int count = 1; count < cutPos; count++)
            node = node.next;
        ListNode newHead = node.next;
        node.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode input = ListNode.getLinkedList(1, 2, 3, 4, 5);
        LC61 solution = new LC61();
        System.out.println(solution.rotateRight(input, 2));
    }
}
