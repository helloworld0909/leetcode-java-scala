package com.helloworld09.leetcode.java.util;

import java.util.*;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return getPreorder().toString();
    }

    public List<Integer> getPreorder() {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = this;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                preorder.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return preorder;
    }

    public List<Integer> getInorder() {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = this;

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                inorder.add(cur.val);
                cur = cur.right;
            }
        }
        return inorder;
    }
}
