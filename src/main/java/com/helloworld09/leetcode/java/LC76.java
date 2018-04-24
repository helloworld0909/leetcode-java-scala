package com.helloworld09.leetcode.java;

import java.util.*;

public class LC76 {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * Example:
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineRecursion(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combineRecursion(int begin, int end, int k, List<Integer> res, List<List<Integer>> result) {
        if (k == 0)
            result.add(new ArrayList<>(res));

        if (begin > end)
            return;

        for (int i = begin; i <= end + 1 - k; i++) {
            res.add(i);
            combineRecursion(i + 1, end, k - 1, res, result);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC76 solution = new LC76();
        System.out.println(solution.combine(5, 3));
    }
}
