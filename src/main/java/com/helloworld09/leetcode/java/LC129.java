package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.TreeNode;

public class LC129 {
    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p>
     * Find the total sum of all root-to-leaf numbers.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * 1
     * / \
     * 2   3
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     * Example 2:
     * <p>
     * Input: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * Output: 1026
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursive(root, 0);
    }

    private int sumNumbersRecursive(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }

        curSum += root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        }
        return sumNumbersRecursive(root.left, curSum * 10) + sumNumbersRecursive(root.right, curSum * 10);
    }

    public static void main(String[] args) {
        LC129 solution = new LC129();
        System.out.println(solution.sumNumbers(TreeNode.getTestTree()));
    }
}
