package com.helloworld09.leetcode.java.util;

import java.util.*;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode() {
    }

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

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;
            List<TreeNode> newQueue = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }
            queue = newQueue;
        }
        return depth;
    }

    public static TreeNode getTestTree() {
        TreeNode input = new TreeNode(0);
        input.left = new TreeNode(1);
        input.right = new TreeNode(2);
        input.left.left = new TreeNode(3);
        return input;
    }

    public static void main(String[] args) {
        System.out.println(getDepth(getTestTree()));
    }
}
