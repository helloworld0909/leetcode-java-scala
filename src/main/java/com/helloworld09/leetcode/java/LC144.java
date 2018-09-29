package com.helloworld09.leetcode.java;

import java.util.*;
import com.helloworld09.leetcode.java.util.TreeNode;

public class LC144 {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,2,3]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                traversal.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return traversal;
    }

    public static void main(String[] args) {
        LC144 solution = new LC144();
        System.out.println(solution.preorderTraversal(TreeNode.getTestTree()));
    }
}
