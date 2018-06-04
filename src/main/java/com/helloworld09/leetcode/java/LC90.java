package com.helloworld09.leetcode.java;

import java.util.*;


public class LC90 {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,2]
     * Output:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupRecursion(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsetsWithDupRecursion(int[] nums, int begin, List<Integer> curSet, List<List<Integer>> result) {
        if (begin >= nums.length) {
            result.add(new ArrayList<>(curSet));
            return;
        }
        int num = nums[begin];
        int nextIdx = begin + 1;
        while (nextIdx < nums.length && nums[nextIdx] == num) {
            nextIdx++;
        }

        subsetsWithDupRecursion(nums, nextIdx, curSet, result);

        curSet.add(num);
        subsetsWithDupRecursion(nums, begin + 1, curSet, result);
        curSet.remove(curSet.size() - 1);
    }

    public static void main(String[] args) {
        LC90 solution = new LC90();
        int[] input = new int[]{1, 2, 2};
        System.out.println(solution.subsetsWithDup(input));
    }
}
