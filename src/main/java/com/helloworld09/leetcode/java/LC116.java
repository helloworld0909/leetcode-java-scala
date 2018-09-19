package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.TreeLinkNode;
import com.helloworld09.leetcode.java.util.TreeVisualize;

public class LC116 {
    /**
     * Given a binary tree
     * <p>
     * struct TreeLinkNode {
     * TreeLinkNode *left;
     * TreeLinkNode *right;
     * TreeLinkNode *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * Initially, all next pointers are set to NULL.
     * <p>
     * Note:
     * <p>
     * You may only use constant extra space.
     * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     * Example:
     * <p>
     * Given the following perfect binary tree,
     * <p>
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 4  5  6  7
     * After calling your function, the tree should look like:
     * <p>
     * 1 -> NULL
     * /  \
     * 2 -> 3 -> NULL
     * / \  / \
     * 4->5->6->7 -> NULL
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        TreeLinkNode next = root.next;
        if (left != null) {
            left.next = right;
        }
        if (next != null && right != null) {
            right.next = next.left;
        }

        connect(left);
        connect(right);
    }

    public static void main(String[] args) {
        LC116 solution = new LC116();
        TreeLinkNode input = TreeLinkNode.getTestTree();
        input.left.next = null;
        solution.connect(input);
        TreeVisualize.draw(input);
    }
}
