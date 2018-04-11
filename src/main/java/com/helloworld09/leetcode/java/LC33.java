package com.helloworld09.leetcode.java;

public class LC33 {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length < 1)
            return -1;
        int pivot = findPivot(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int biasMid = (mid + pivot) % length;
            if (nums[biasMid] == target)
                return biasMid;
            else if (nums[biasMid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private static int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midElem = nums[mid];
            if (mid + 1 < nums.length && midElem > nums[mid + 1])
                return mid + 1;
            if (nums[left] <= midElem)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC33 solution = new LC33();
        int[] input = {3,1};
        System.out.println(solution.search(input, 3));
    }
}
