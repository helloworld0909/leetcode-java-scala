package com.helloworld09.leetcode.java;


public class LC96 {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: 5
     * Explanation:
     * Given n = 3, there are a total of 5 unique BST's:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     */
    public int numTrees(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                num += table[j - 1] * table[i - j];
            }
            table[i] = num;
        }
        return table[n];
    }

    public static void main(String[] args) {
        LC96 solution = new LC96();
        System.out.println(solution.numTrees(10));
    }
}
