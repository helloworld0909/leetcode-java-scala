package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.ListNode;
import com.helloworld09.leetcode.java.util.TreeNode;


public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTRecursion(head, null);
    }

    private TreeNode sortedListToBSTRecursion(ListNode begin, ListNode end) {
        if (begin == null || begin == end) {
            return null;
        }

        ListNode fast = begin, slow = begin;
        while (fast != end && fast != null) {
            fast = fast.next;
            if (fast == end) {
                break;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBSTRecursion(begin, slow);
        root.right = sortedListToBSTRecursion(slow.next, end);
        return root;
    }

    public static void main(String[] args) {
        LC109 solution = new LC109();
        ListNode input = ListNode.getLinkedList(1, 2, 3, 4, 5, 6);
        System.out.println(new LC102().levelOrder(solution.sortedListToBST(input)));
    }
}
