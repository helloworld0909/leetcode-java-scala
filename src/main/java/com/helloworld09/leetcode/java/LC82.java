package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;


public class LC82 {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->3->4->4->5
     * Output: 1->2->5
     * Example 2:
     * <p>
     * Input: 1->1->1->2->3
     * Output: 2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        newHead.next = head;
        ListNode left = newHead, right;

        while (left != null) {
            right = left.next;
            if (right == null)
                break;
            int val = right.val;

            if (right.next != null && val == right.next.val) {
                while (right != null && val == right.val)
                    right = right.next;
                left.next = right;
            } else {
                left = right;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        LC82 solution = new LC82();
        ListNode input = ListNode.getLinkedList(1, 2, 3, 3, 4, 4, 5);
        input = solution.deleteDuplicates(input);
        System.out.println(input);
    }
}
