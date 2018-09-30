package com.helloworld09.leetcode.java;

public class LC153 {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     */
    public int findMin(int[] nums) {
        return findMinRecursive(nums, 0, nums.length - 1);
    }

    private int findMinRecursive(int[] nums, int begin, int end) {
        if (begin == end || begin + 1 == end) {
            return Math.min(nums[begin], nums[end]);
        }

        int midIdx = (begin + end) / 2;
        int mid = nums[midIdx];
        int left = nums[midIdx - 1];
        int right = nums[end];
        if (mid > left && mid < right) {
            return findMinRecursive(nums, begin, midIdx - 1);
        } else if (mid > left && mid > right) {
            return findMinRecursive(nums, midIdx + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        LC153 solution = new LC153();
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
