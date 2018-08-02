package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC94 {
    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                traversal.add(cur.val);
                cur = cur.right;
            }
        }
        return traversal;
    }

    public static void main(String[] args) {
        LC94 solution = new LC94();
        TreeNode input = new TreeNode(0);
        input.left = new TreeNode(1);
        input.right = new TreeNode(2);
        input.left.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(input));
    }
}
