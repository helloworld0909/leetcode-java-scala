package com.helloworld09.leetcode.java;

import java.util.*;

public class LC47 {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,1,2]
     * Output:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] mask = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        findPermuteUnique(nums, mask, new ArrayList<>(), result);
        return result;
    }

    private void findPermuteUnique(int[] nums, boolean[] mask, List<Integer> res, List<List<Integer>> result) {
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mask[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !mask[i - 1])
                continue;

            res.add(nums[i]);
            mask[i] = true;
            findPermuteUnique(nums, mask, res, result);
            mask[i] = false;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC47 solution = new LC47();
        int[] input = {1, 1, 3};
        System.out.println(solution.permuteUnique(input));
    }
}
