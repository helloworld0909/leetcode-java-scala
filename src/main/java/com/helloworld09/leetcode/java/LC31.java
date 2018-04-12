package com.helloworld09.leetcode.java;


import java.util.Arrays;

public class LC31 {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place, do not allocate extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        // Find descending ordered elements from the tail
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        // sort these elements lexicographically
        reverse(nums, i, nums.length - 1);

        // Find the smallest element which is greater than nums[i - 1], then swap
        if (i > 0) {
            int headIdx = i - 1;
            int head = nums[headIdx];
            while (i < nums.length - 1 && nums[i] <= head) i++;
            int temp = nums[headIdx];
            nums[headIdx] = nums[i];
            nums[i] = temp;
        }
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int left = begin, right = end; left < right; left++, right--) {
            // swap the values at the left and right indices
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    public static void main(String[] args) {
        LC31 solution = new LC31();
        int[] nums = {5, 1, 1, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
