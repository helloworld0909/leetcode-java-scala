package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

import java.util.LinkedList;

public class LC142 {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p>
     * Note: Do not modify the linked list.
     * <p>
     * Follow up:
     * Can you solve it without using extra space?
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LC142 solution = new LC142();
        ListNode input = ListNode.getLinkedList(1,2,3,4);
        if (input != null) {
            input.next.next.next.next = input.next;
        }
        System.out.println(solution.detectCycle(input).val);
    }
}
