package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        //First Step: find the node on the middle
        ListNode mid = head, fast = head;
        ListNode tail = head;
        while (fast != null) {
            tail = fast;
            fast = fast.next;
            if (fast == null) {
                break;
            } else {
                fast = fast.next;
                tail = tail.next;
            }
            mid = mid.next;

        }

        //Second Step: reverse the second half
        ListNode node1 = mid, node2 = mid;
        if (mid != null) {
            node2 = node2.next;
            node1.next = null;
        }
        while (node2 != null) {
            ListNode tmp = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = tmp;
        }

        //Third Step: Merge the first half and the second half
        node1 = head;
        node2 = tail;
        while (node1 != null && node1.next != node2) {
            ListNode tmp1 = node1.next, tmp2 = node2.next;
            node1.next = node2;
            node1 = tmp1;
            node2.next = node1;
            node2 = tmp2;
        }
    }

    public static void main(String[] args) {
        LC143 solution = new LC143();
        ListNode input = ListNode.getLinkedList(1, 2, 3, 4);
        solution.reorderList(input);
        System.out.println(input);
    }
}
