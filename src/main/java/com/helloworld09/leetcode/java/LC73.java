package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.Grid;

public class LC73 {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * Output:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     * Example 2:
     * <p>
     * Input:
     * [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]
     * ]
     * Output:
     * [
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]
     * ]
     * Follow up:
     * <p>
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        boolean isFirstColZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                isFirstColZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (isFirstColZero)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                new int[]{-4, -2147483648, 6, -7, 0},
                new int[]{-8, 6, -8, -6, 0},
                new int[]{2147483647, 2, -9, -6, -10}
        };
        LC73 solution = new LC73();
        solution.setZeroes(grid);
        Grid.printGrid(grid);
    }
}
