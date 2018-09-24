package com.helloworld09.leetcode.java;

import java.util.*;

public class LC131 {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return all possible palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     */
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        partitionRecursive(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partitionRecursive(String s, int begin, List<String> cur, List<List<String>> res) {
        if (begin >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = begin + 1; i <= s.length(); i++) {
            if (isPalindrome(s, begin, i)) {
                cur.add(s.substring(begin, i));
                partitionRecursive(s, i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (end <= begin) {
            return false;
        }
        while (end - begin > 1) {
            if (s.charAt(begin) != s.charAt(end - 1)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC131 solution = new LC131();
        System.out.println(solution.partition("aab"));
    }
}


