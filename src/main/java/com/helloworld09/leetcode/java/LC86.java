package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC86 {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * Example:
     * <p>
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(Integer.MAX_VALUE);
        ListNode greaterHead = new ListNode(Integer.MAX_VALUE);
        ListNode less = lessHead, greater = greaterHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = new ListNode(cur.val);
                less = less.next;
            } else {
                greater.next = new ListNode(cur.val);
                greater = greater.next;
            }
            cur = cur.next;
        }
        less.next = greaterHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        LC86 solution = new LC86();
        ListNode input = ListNode.getLinkedList(1, 4, 3, 2, 5, 2);
        System.out.println(solution.partition(input, 3));
    }
}
