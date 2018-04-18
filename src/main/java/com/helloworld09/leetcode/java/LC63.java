package com.helloworld09.leetcode.java;

public class LC63 {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = m != 0 ? obstacleGrid[0].length : 0;

        if (m == 0 || n == 0)
            return 0;

        int[][] table = new int[m][n];
        table[0][0] = obstacleGrid[m - 1][n - 1] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[m - 1 - i][n - 1] == 1)
                table[i][0] = 0;
            else
                table[i][0] = table[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[m - 1][n - 1 - j] == 1)
                table[0][j] = 0;
            else
                table[0][j] = table[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[m - 1 - i][n - 1 - j] == 1)
                    table[i][j] = 0;
                else
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LC63 solution = new LC63();
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[1][1] = 1;
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
