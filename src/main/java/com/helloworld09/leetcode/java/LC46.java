package com.helloworld09.leetcode.java;

import java.util.*;

public class LC46 {
    /**
     * Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] mask = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        findPermute(nums, mask, new ArrayList<>(), result);
        return result;
    }

    private void findPermute(int[] nums, boolean[] mask, List<Integer> res, List<List<Integer>> result) {
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mask[i])
                continue;
            res.add(nums[i]);
            mask[i] = true;
            findPermute(nums, mask, res, result);
            mask[i] = false;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC46 solution = new LC46();
        int[] input = {1, 2, 3};
        System.out.println(solution.permute(input));
    }
}

