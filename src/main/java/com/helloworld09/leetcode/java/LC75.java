package com.helloworld09.leetcode.java;

import java.util.Arrays;

public class LC75 {
    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: You are not suppose to use the library's sort function for this problem.
     * <p>
     * Example:
     * <p>
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Follow up:
     * <p>
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with a one-pass algorithm using only constant space?
     */
    public void sortColors(int[] nums) {
        int div0 = 0, div1 = 0, div2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                nums[div2++] = 2;
                nums[div1++] = 1;
                nums[div0++] = 0;
            } else if (num == 1) {
                nums[div2++] = 2;
                nums[div1++] = 1;
            } else {
                div2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};
        LC75 solution = new LC75();
        solution.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
