package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC95 {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output:
     * [
     * [1,null,3,2],
     * [3,2,null,1],
     * [3,1,null,null,2],
     * [2,1,3],
     * [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        } else {
            return generateTreesAuxillary(1, n);
        }
    }

    private List<TreeNode> generateTreesAuxillary(int begin, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (begin > end) {
            trees.add(null);
        } else if (begin == end) {
            trees.add(new TreeNode(begin));
        } else {
            for (int i = begin; i <= end; i++) {
                List<TreeNode> leftTrees = generateTreesAuxillary(begin, i - 1);
                List<TreeNode> rightTrees = generateTreesAuxillary(i + 1, end);

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {

                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        trees.add(root);
                    }
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        LC95 solution = new LC95();
        System.out.println(solution.generateTrees(0));
        System.out.println(solution.generateTrees(3));
    }
}
