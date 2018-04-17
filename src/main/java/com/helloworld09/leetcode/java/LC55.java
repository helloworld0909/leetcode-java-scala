package com.helloworld09.leetcode.java;

public class LC55 {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */
    public boolean canJump(int[] nums) {
        boolean can = true;
        int begin = 0;
        for (int i = begin; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length - 1 && nums[j] == 0)
                    j++;
                int barriers = j - i;
                can = can && canJumpOver(nums, begin, i - 1, barriers);
                // Skip i
                i = j;
            }
        }
        return can;
    }

    private boolean canJumpOver(int[] nums, int begin, int end, int barriers) {
        for (int i = end; i >= begin; i--) {
            if (nums[i] > end - i + barriers)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {3, 0, 0, 0};
        LC55 solution = new LC55();
        System.out.println(solution.canJump(input));
    }
}
