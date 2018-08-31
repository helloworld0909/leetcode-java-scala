package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;
import com.helloworld09.leetcode.java.util.TreeVisualize;

public class LC114 {
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode tail = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                tail = cur;
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.pop();
                cur = cur.right;
                if (cur != null) {
                    tail.left = cur;
                }
            }
        }

        cur = root;
        while (cur != null) {
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        LC114 solution = new LC114();
        TreeNode input = TreeNode.getTestTree();
        solution.flatten(input);
        TreeVisualize.draw(input);
    }
}
