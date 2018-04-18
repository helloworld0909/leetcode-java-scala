package com.helloworld09.leetcode.java;

public class LC62 {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     * <p>
     * Above is a 7 x 3 grid. How many possible unique paths are there?
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     * Example 2:
     * <p>
     * Input: m = 7, n = 3
     * Output: 28
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) table[i][0] = 1;
        for (int j = 0; j < n; j++) table[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LC62 solution = new LC62();
        System.out.println(solution.uniquePaths(51, 9));
    }
}
