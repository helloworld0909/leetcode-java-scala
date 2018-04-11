package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;
import java.util.Arrays;


public class LC24 {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * <p>
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode a = head, pre;
        ListNode b = head.next;
        while (true) {
            a.next = b.next;
            b.next = a;
            pre = a;

            a = a.next;
            if (a == null)
                break;
            b = a.next;
            if (b == null)
                break;
            pre.next = b;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(0);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(3);
        ListNode rev = swapPairs(input);
        System.out.println(Arrays.asList(rev.val, rev.next.val, rev.next.next.val, rev.next.next.next.val));
        System.out.println(swapPairs(null));
        System.out.println(swapPairs(new ListNode(0)).val);
    }
}
