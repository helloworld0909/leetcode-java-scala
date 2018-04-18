package com.helloworld09.leetcode.java;


public class LC540 {
    /**
     * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
     * <p>
     * Example 1:
     * Input: [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     * Input: [3,3,7,7,10,11,11]
     * Output: 10
     * Note: Your solution should run in O(log n) time and O(1) space.
     */
    public int singleNonDuplicate(int[] nums) {
        int idx = findSingle(nums, 0, nums.length - 1);
        return nums[idx];
    }

    private int findSingle(int[] nums, int start, int end) {
        if (start == end)
            return start;
        else if (start > end || start + 1 == end)
            return -1;
        else {
            int mid = (start + end) / 2;
            if (nums[mid] == nums[mid + 1]) {
                int leftRet = findSingle(nums, start, mid - 1);
                if (leftRet != -1)
                    return leftRet;
                int rightRet = findSingle(nums, mid + 2, end);
                if (rightRet != -1)
                    return rightRet;
            } else if (nums[mid] == nums[mid - 1]) {
                int leftRet = findSingle(nums, start, mid - 2);
                if (leftRet != -1)
                    return leftRet;
                int rightRet = findSingle(nums, mid + 1, end);
                if (rightRet != -1)
                    return rightRet;
            } else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC540 solution = new LC540();
        int[] input = new int[]{1, 1, 2};
        System.out.println(solution.singleNonDuplicate(input));
    }
}
