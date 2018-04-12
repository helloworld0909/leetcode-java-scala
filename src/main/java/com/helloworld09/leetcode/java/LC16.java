package com.helloworld09.leetcode.java;

import java.util.Arrays;

public class LC16 {
    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int firstIdx = 0; firstIdx < nums.length - 2; firstIdx++) {
            int twoSum = twoSumClosest(nums, target - nums[firstIdx], firstIdx + 1);
            int threeSum = twoSum + nums[firstIdx];
            if (threeSum == target)
                return threeSum;
            if (Math.abs(closestSum - target) > Math.abs(threeSum - target))
                closestSum = threeSum;
        }
        return closestSum;
    }

    private int twoSumClosest(int[] nums, int target, int begin) {
        int lo = begin, hi = nums.length - 1;
        int closestSum = nums[lo] + nums[hi];

        while (lo < hi) {
            int newDiff = nums[lo] + nums[hi] - target;
            if (newDiff == 0)
                return target;
            if (Math.abs(newDiff) < Math.abs(closestSum - target)) {
                closestSum = nums[lo] + nums[hi];
            }
            if (newDiff > 0) hi--;
            else lo++;
        }
        return closestSum;
    }

    public static void main(String[] args) {
        LC16 solution = new LC16();
        int[] input = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(solution.threeSumClosest(input, 82));
    }
}
