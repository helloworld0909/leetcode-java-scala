package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC147 {
    /**
     * Sort a linked list using insertion sort.     *
     * <p>
     * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
     * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
     * <p>
     * Algorithm of Insertion Sort:
     * <p>
     * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
     * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
     * It repeats until no input elements remain.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            head = insert(head, cur);
            cur = tmp;
        }
        return head;
    }

    private ListNode insert(ListNode head, ListNode cur) {
        if (head == null) {
            return cur;
        }
        if (cur == null) {
            return head;
        }

        if (cur.val < head.val) {
            cur.next = head;
            return cur;
        }
        ListNode iter = head;
        while (iter.next != null) {
            if (iter.next.val > cur.val) {
                cur.next = iter.next;
                iter.next = cur;
                return head;
            }
            iter = iter.next;
        }
        iter.next = cur;
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        LC147 solution = new LC147();
        System.out.println(solution.insertionSortList(ListNode.getLinkedList(-1, 5, 3, 4, 0)));
    }
}
