package com.helloworld09.leetcode.java;

import java.util.*;

public class LC93 {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * <p>
     * Example:
     * <p>
     * Input: "25525511135"
     * Output: ["255.255.11.135", "255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> comb = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (isValid(s, k, s.length()) && isValid(s, j, k) && isValid(s, i, j) && isValid(s, 0, i)) {
                        StringBuilder ip = new StringBuilder(s);
                        ip.insert(k, '.');
                        ip.insert(j, '.');
                        ip.insert(i, '.');
                        comb.add(ip.toString());
                    }
                }
            }
        }
        return comb;
    }

    private boolean isValid(String s, int begin, int end) {
        if (end > s.length() || begin >= end || end - begin > 3) {
            return false;
        }
        String sub = s.substring(begin, end);
        return !(Integer.parseInt(sub) > 255 || (sub.charAt(0) == '0' && sub.length() > 1));
    }

    public static void main(String[] args) {
        LC93 solution = new LC93();
        String input = "010010";
        System.out.println(solution.restoreIpAddresses(input));
    }
}
