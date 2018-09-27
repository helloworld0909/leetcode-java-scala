package com.helloworld09.leetcode.java;

public class LC137 {
    /**
     * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,3,2]
     * Output: 3
     * Example 2:
     * <p>
     * Input: [0,1,0,1,0,1,99]
     * Output: 99
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i : nums) {
            b = b ^ i & (~a);
            a = a ^ i & (~b);
        }
        return a | b;
    }

    public static void main(String[] args) {
        LC137 solution = new LC137();
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
