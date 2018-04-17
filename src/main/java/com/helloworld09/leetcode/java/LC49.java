package com.helloworld09.leetcode.java;

import java.util.*;

public class LC49 {
    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupBySorted = new HashMap<>();
        for (String s: strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = new String(tmp);
            groupBySorted.putIfAbsent(sortedStr, new ArrayList<>());
            groupBySorted.get(sortedStr).add(s);
        }

        return new ArrayList<>(groupBySorted.values());
    }

    public static void main(String[] args) {
        LC49 solution = new LC49();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(input));
    }
}
