package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC98 {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p>
     * Assume a BST is defined as follows:
     * <p>
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * Example 1:
     * <p>
     * Input:
     * 2
     * / \
     * 1   3
     * Output: true
     * Example 2:
     * <p>
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * Output: false
     * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
     * is 5 but its right child's value is 4.
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre != null && pre.val >= cur.val){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    public static void main(String[] args) {
        LC98 solution = new LC98();
        TreeNode input = TreeNode.getTestTree();
        System.out.println(solution.isValidBST(input));
    }
}
