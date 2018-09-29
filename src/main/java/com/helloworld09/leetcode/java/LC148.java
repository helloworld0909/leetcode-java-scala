package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC148 {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * <p>
     * Example 1:
     * <p>
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     * <p>
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     */
    public ListNode sortList(ListNode head) {
        int length = lengthOf(head);
        return mergeSort(head, length / 2);
    }

    private ListNode mergeSort(ListNode head, int midLength) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (midLength > 1) {
            midLength--;
            cur = cur.next;
        }
        ListNode head2 = cur.next;
        cur.next = null;
        ListNode l1 = mergeSort(head, midLength / 2);
        ListNode l2 = mergeSort(head2, midLength / 2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 == null) {
            cur.next = head2;
        }
        if (head2 == null) {
            cur.next = head1;
        }
        return dummy.next;
    }

    private int lengthOf(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        LC148 solution = new LC148();
        ListNode input = ListNode.getLinkedList(-1, 5, 3, 4, 0);
        System.out.println(solution.sortList(input));
    }
}
