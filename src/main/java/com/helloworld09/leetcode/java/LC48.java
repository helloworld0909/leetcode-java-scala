package com.helloworld09.leetcode.java;

import java.util.Arrays;

public class LC48 {
    /**
     * You are given an n x n 2D matrix representing an image.
     * <p>
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note:
     * <p>
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * Example 1:
     * <p>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * Example 2:
     * <p>
     * Given input matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     */
    public void rotate(int[][] matrix) {
        for (int size = matrix.length % 2 == 0 ? 2 : 1; size <= matrix.length; size += 2)
            rotateSquare(matrix, size);
    }

    private void rotateSquare(int[][] matrix, int size) {
        int upperLeft = matrix.length / 2 - size / 2;
        int lowerRight = upperLeft + size - 1;
        for (int i = 0; i < size - 1; i++) {
            int tmp = matrix[upperLeft][upperLeft + i];
            matrix[upperLeft][upperLeft + i] = matrix[lowerRight - i][upperLeft];
            matrix[lowerRight - i][upperLeft] = matrix[lowerRight][lowerRight - i];
            matrix[lowerRight][lowerRight - i] = matrix[upperLeft + i][lowerRight];
            matrix[upperLeft + i][lowerRight] = tmp;
        }
    }

    public static void main(String[] args) {
        LC48 solution = new LC48();
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                matrix[i][j] = 3 * i + j;
        }
        for (int i = 0; i< 3; i++)
            System.out.println(Arrays.toString(matrix[i]));
        solution.rotate(matrix);
        for (int i = 0; i< 3; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
