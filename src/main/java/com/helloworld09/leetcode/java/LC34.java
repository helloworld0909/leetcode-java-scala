package com.helloworld09.leetcode.java;

import java.util.Arrays;

public class LC34 {
    /**
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null)
            return new int[]{-1, -1};

        int leftBound = lowerBound(nums, target);
        int rightBound = lowerBound(nums, target + 1);
        if (leftBound < nums.length && nums[leftBound] == target) {
            return new int[]{leftBound, rightBound - 1};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        LC34 solution = new LC34();
        int[] input = {5, 7, 7, 8, 8, 10};
        System.out.println(solution.lowerBound(input, 8));
        System.out.println(Arrays.toString(solution.searchRange(input, 8)));
    }
}

