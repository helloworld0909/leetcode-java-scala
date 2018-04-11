package com.helloworld09.leetcode.java;

import scala.Int;

import java.util.*;

public class LC39 {
    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     * [
     * [7],
     * [2, 2, 3]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinationSum(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(comb);
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                List<Integer> newComb = new ArrayList<>(comb);
                newComb.add(candidates[i]);
                findCombinationSum(candidates, target - candidates[i], i, newComb, res);
            }
        }
    }

    public static void main(String[] args) {
        LC39 solution = new LC39();
        int[] input = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(input, 7));
    }
}
