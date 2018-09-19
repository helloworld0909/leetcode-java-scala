package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.TreeLinkNode;
import com.helloworld09.leetcode.java.util.TreeVisualize;

public class LC117 {
    /**
     * Given a binary tree
     *
     * struct TreeLinkNode {
     *   TreeLinkNode *left;
     *   TreeLinkNode *right;
     *   TreeLinkNode *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     * Note:
     *
     * You may only use constant extra space.
     * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     * Example:
     *
     * Given the following binary tree,
     *
     *      1
     *    /  \
     *   2    3
     *  / \    \
     * 4   5    7
     * After calling your function, the tree should look like:
     *
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \    \
     * 4-> 5 -> 7 -> NULL
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode dummyChild = new TreeLinkNode(0);
            TreeLinkNode curChild = dummyChild;
            while (cur != null) {
                if (cur.left != null) {
                    curChild.next = cur.left;
                    curChild = curChild.next;
                }
                if (cur.right != null) {
                    curChild.next = cur.right;
                    curChild = curChild.next;
                }
                cur = cur.next;
            }
            cur = dummyChild.next;
        }
    }

    public static void main(String[] args) {
        LC117 solution = new LC117();
        TreeLinkNode input = TreeLinkNode.getTestTree();
        input.left.next = null;
        solution.connect(input);
        TreeVisualize.draw(input);
    }
}
