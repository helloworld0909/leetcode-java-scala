package com.helloworld09.leetcode.java;

public class LC11 {

    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container and n is at least 2.
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = getArea(i, j, height[i], height[j]);
        while (i < j) {
            // Change the shorter line
            if (height[i] < height[j]) {
                do i++; while (i < j && height[i] > height[i]);
            } else {
                do j--; while (i < j && height[j] > height[j]);
            }
            int area = getArea(i, j, height[i], height[j]);
            if (area >= maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    private int getArea(int i, int j, int a_i, int a_j) {
        return Math.min(a_i, a_j) * Math.abs(i - j);
    }

    public static void main(String[] args) {
        LC11 solution = new LC11();
        int[] input = {1, 2, 4, 3};
        System.out.println(solution.maxArea(input));
    }
}
