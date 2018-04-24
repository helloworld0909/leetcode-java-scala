package com.helloworld09.leetcode.java;

import com.helloworld09.leetcode.java.util.Grid;

public class LC74 {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     * <p>
     * Input:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     * <p>
     * Input:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;

        int begin = 0, end = m * n - 1, mid = (begin + end) / 2;
        while (begin <= end) {
            int i = mid / n;
            int j = mid % n;
            int value = matrix[i][j];
            if (value == target)
                return true;
            else if (value < target)
                begin = mid + 1;
            else
                end = mid - 1;
            mid = (begin + end) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = Grid.parseGrid("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]");
        LC74 solution = new LC74();
        System.out.println(solution.searchMatrix(input, 3));
    }
}
