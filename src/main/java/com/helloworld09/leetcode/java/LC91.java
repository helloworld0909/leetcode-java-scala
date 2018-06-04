package com.helloworld09.leetcode.java;


public class LC91 {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     * <p>
     * Example 1:
     * <p>
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     * <p>
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] aux = new int[s.length() + 1];
        aux[0] = 1;
        aux[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            if (cur == '0') {
                if (pre != '1' && pre != '2'){
                    return 0;
                } else {
                    aux[i + 1] = aux[i - 1];
                }
            } else if (pre == '1' || (pre == '2' && cur <= '6')) {
                aux[i + 1] = aux[i] + aux[i - 1];
            } else {
                aux[i + 1] = aux[i];
            }
        }
        return aux[aux.length - 1];
    }

    public static void main(String[] args) {
        LC91 solution = new LC91();
        System.out.println(solution.numDecodings("1110"));
    }
}
