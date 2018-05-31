package com.helloworld09.leetcode.java;

public class LC81 {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return true, otherwise return false.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * Follow up:
     * <p>
     * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     * Would this affect the run-time complexity? How and why?
     */
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[(mid + pivot) % nums.length];
            if (num == target)
                return true;
            else if (num < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    private int findPivot(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC81 solution = new LC81();
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 6));
    }
}
