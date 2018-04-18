package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.Grid;

public class LC59 {
    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     */
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int i = 0, j = 0, direction = 0;
        for (int num = 1; num <= n * n; num++) {
            matrix[i][j] = num;
            int tmp1 = i, tmp2 = j;
            int[] pair = next(i, j, direction);
            i = pair[0]; j = pair[1];
            if (i < 0 || i >= n || j < 0 || j >= n || matrix[i][j] != 0) {
                direction = (direction + 1) % 4;
                i = tmp1;
                j = tmp2;
                int[] pair2 = next(i, j, direction);
                i = pair2[0]; j = pair2[1];
            }
        }
        return matrix;
    }

    private int[] next(int i, int j, int direction){
        switch (direction) {
            case 0:
                j++;
                break;
            case 1:
                i++;
                break;
            case 2:
                j--;
                break;
            case 3:
                i--;
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        LC59 solution = new LC59();
        Grid.printGrid(solution.generateMatrix(3));
    }
}
