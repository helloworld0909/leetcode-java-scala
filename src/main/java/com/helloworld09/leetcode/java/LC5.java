package com.helloworld09.leetcode.java;


public class LC5 {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     */

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        String candidate = "";
        for (int mid = 0; mid < s.length(); mid++) {
            String even = findEvenPalindrome(s, mid);
            String odd = findOddPalindrome(s, mid);
            if (even.length() > candidate.length()) {
                candidate = even;
            }
            if (odd.length() > candidate.length()) {
                candidate = odd;
            }
        }
        return candidate;
    }

    private String findEvenPalindrome(String s, int mid) {
        int left = mid, right = mid + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return s.substring(left + 1, right);
    }

    private String findOddPalindrome(String s, int mid) {
        int left = mid - 1, right = mid + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return s.substring(left + 1, right);
    }

    //TODO Still O(n^2)
    public static void main(String[] args) {
        LC5 solution = new LC5();
        System.out.println(solution.longestPalindrome("babad"));
    }
}
