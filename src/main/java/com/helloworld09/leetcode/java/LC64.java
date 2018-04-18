package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.Grid;

import java.util.Arrays;

public class LC64 {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = m != 0 ? grid[0].length : 0;
        if (m == 0 || n == 0)
            return 0;

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0)
                    table[i][j] = table[i][j - 1] + grid[i][j];
                else if (i != 0 && j == 0)
                    table[i][j] = table[i - 1][j] + grid[i][j];
                else if (i != 0) {
                    table[i][j] = grid[i][j] + Math.min(table[i - 1][j], table[i][j - 1]);
                } else {
                    table[i][j] = grid[i][j];
                }
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = Grid.getRandomGrid(3, 3);
        Grid.printGrid(grid);
        LC64 solution = new LC64();
        System.out.println(solution.minPathSum(grid));
    }
}
