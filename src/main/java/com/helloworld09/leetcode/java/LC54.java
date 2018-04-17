package com.helloworld09.leetcode.java;

import java.util.*;

public class LC54 {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        List<Integer> order = new ArrayList<>();
        for (int idx = 0; idx * 2 < Math.min(matrix.length, matrix[0].length); idx++)
            spiralCircle(matrix, idx, order);

        // Cut off error elements due to corner cases
        int length = matrix.length * matrix[0].length;
        return order.subList(0, length);
    }

    private void spiralCircle(int[][] matrix, int idx, List<Integer> order) {

        int height = matrix.length;
        int width = matrix[0].length;
        if (idx == height / 2 && idx == width / 2){
            order.add(matrix[idx][idx]);
            return;
        }

        for (int j = idx; j < width - idx - 1; j++) order.add(matrix[idx][j]);
        for (int i = idx; i < height - idx - 1; i++) order.add(matrix[i][width - idx - 1]);
        for (int j = width - idx - 1; j > idx; j--) order.add(matrix[height - idx - 1][j]);
        for (int i = height - idx - 1; i > idx; i--) order.add(matrix[i][idx]);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                matrix[i][j] = 5 * i + j + 1;
        }
        LC54 solution = new LC54();
        System.out.println(solution.spiralOrder(matrix));
    }
}
