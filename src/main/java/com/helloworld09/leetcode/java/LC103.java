package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC103 {
    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isReverse = false;

        while (!queue.isEmpty()) {
            List<TreeNode> newQueue = new LinkedList<>();
            List<Integer> traversal = new ArrayList<>();
            for (TreeNode node : queue) {
                traversal.add(node.val);
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }
            if (isReverse) {
                Collections.reverse(traversal);
            }
            ret.add(traversal);

            queue = newQueue;
            isReverse = !isReverse;
        }
        return ret;
    }

    public static void main(String[] args) {
        LC103 solution = new LC103();
        System.out.println(solution.zigzagLevelOrder(TreeNode.getTestTree()));
    }
}
