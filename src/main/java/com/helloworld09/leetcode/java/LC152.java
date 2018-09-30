package com.helloworld09.leetcode.java;

public class LC152 {
    /**
     * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     * <p>
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */
    public int maxProduct(int[] nums) {
        int[] maxPositive = new int[nums.length];
        int[] maxNegative = new int[nums.length];

        maxPositive[0] = nums[0] > 0 ? nums[0] : 0;
        maxNegative[0] = nums[0] < 0 ? nums[0] : 0;

        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxPositive[i] = Math.max(nums[i], nums[i] * maxPositive[i - 1]);
                maxNegative[i] = nums[i] * maxNegative[i - 1];
            } else {
                maxPositive[i] = nums[i] * maxNegative[i - 1];
                maxNegative[i] = Math.min(nums[i], nums[i] * maxPositive[i - 1]);
            }
            if (maxPositive[i] > maxProduct) {
                maxProduct = maxPositive[i];
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        LC152 solution = new LC152();
        System.out.println(solution.maxProduct(new int[]{-2}));
    }
}
