package com.helloworld09.leetcode.java;

import java.util.*;

public class LC60 {
    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * Note:
     * <p>
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     */
    public String getPermutation(int n, int k) {
        List<String> remains = new ArrayList<>();
        for (Integer i = 1; i <= n; i++)
            remains.add(i.toString());
        return getPermutation(remains, k);
    }

    private String getPermutation(List<String> remains, int k) {
        if (k == 1)
            return String.join("", remains);

        int n = remains.size();
        int nextFact = factorial(n - 1);
        int nextK = (k - 1) % nextFact + 1;
        int firstDigitIndex = (k - 1) / nextFact;
        String firstDigit = remains.get(firstDigitIndex);
        remains.remove(firstDigitIndex);
        return firstDigit + getPermutation(remains, nextK);

    }

    private int factorial(int k) {
        int f = 1;
        for (int i = 2; i <= k; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args) {
        LC60 solution = new LC60();
        System.out.println(solution.getPermutation(4, 9));
    }
}
