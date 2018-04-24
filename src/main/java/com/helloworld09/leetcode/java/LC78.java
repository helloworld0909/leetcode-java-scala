package com.helloworld09.leetcode.java;

import java.util.*;

public class LC78 {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsRecursion(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsetsRecursion(int[] nums, int begin, List<Integer> curSet, List<List<Integer>> result) {
        if (begin >= nums.length) {
            result.add(new ArrayList<>(curSet));
            return;
        }

        subsetsRecursion(nums, begin + 1, curSet, result);
        curSet.add(nums[begin]);
        subsetsRecursion(nums, begin + 1, curSet, result);
        curSet.remove(curSet.size() - 1);
    }

    public static void main(String[] args) {
        LC78 solution = new LC78();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
