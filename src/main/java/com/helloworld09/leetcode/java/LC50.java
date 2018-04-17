package com.helloworld09.leetcode.java;

public class LC50 {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (xn).
     * <p>
     * Example 1:
     * <p>
     * Input: 2.00000, 10
     * Output: 1024.00000
     * Example 2:
     * <p>
     * Input: 2.10000, 3
     * Output: 9.26100
     * Example 3:
     * <p>
     * Input: 2.00000, -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * Note:
     * <p>
     * -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−231, 231 − 1]
     */
    public double myPow(double x, int n) {
        if (x == 1.0)
            return 1.0;
        if (x == -1.0)
            return n % 2 == 0 ? 1.0 : -1.0;

        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return 0.0;
            return 1.0 / myPow(x, -n);
        } else if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        else {
            double halfPow = myPow(x, n / 2);
            if (halfPow > 46341)
                return Integer.MAX_VALUE;
            return halfPow * halfPow * (n % 2 == 0 ? 1.0 : x);
        }
    }

    public static void main(String[] args) {
        LC50 solution = new LC50();
        System.out.println(solution.myPow(2.00000, -2147483648));
    }
}
