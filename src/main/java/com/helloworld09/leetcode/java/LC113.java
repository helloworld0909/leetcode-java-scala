package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC113 {
    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given the below binary tree and sum = 22,
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * Return:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSumRecursion(root, sum, cur, res);
        return res;
    }

    private void pathSumRecursion(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        cur.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(cur));
        } else {
            pathSumRecursion(root.left, sum - root.val, cur, res);
            pathSumRecursion(root.right, sum - root.val, cur, res);
        }
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        LC113 solution = new LC113();
        TreeNode input = TreeNode.getTestTree();
        System.out.println(solution.pathSum(input, 4));
    }
}
