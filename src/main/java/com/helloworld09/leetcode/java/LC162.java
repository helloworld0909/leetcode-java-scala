package com.helloworld09.leetcode.java;

public class LC162 {
    /**
     * A peak element is an element that is greater than its neighbors.
     * <p>
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * <p>
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * <p>
     * You may imagine that nums[-1] = nums[n] = -∞.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * Example 2:
     * <p>
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     * Note:
     * <p>
     * Your solution should be in logarithmic complexity.
     */
    public int findPeakElement(int[] nums) {
        return findPeakElementRecursive(nums, 0, nums.length - 1);
    }

    private int findPeakElementRecursive(int[] nums, int begin, int end) {
        if (begin == end) {
            return begin;
        }

        int mid = (begin + end) / 2;
        if (mid == 0) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                return findPeakElementRecursive(nums, mid + 1, end);
            }
        }

        int leftElem = nums[mid - 1];
        int rightElem = nums[mid + 1];
        int midElem = nums[mid];
        if (midElem > leftElem && midElem > rightElem) {
            return mid;
        } else if (midElem <= leftElem) {
            return findPeakElementRecursive(nums, begin, mid - 1);
        } else {
            return findPeakElementRecursive(nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        LC162 solution = new LC162();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
