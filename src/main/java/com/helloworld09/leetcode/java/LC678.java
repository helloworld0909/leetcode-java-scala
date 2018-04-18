package com.helloworld09.leetcode.java;


public class LC678 {
    /**
     * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
     * <p>
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     * An empty string is also valid.
     * Example 1:
     * Input: "()"
     * Output: True
     * Example 2:
     * Input: "(*)"
     * Output: True
     * Example 3:
     * Input: "(*))"
     * Output: True
     * Note:
     * The string size will be in the range [1, 100].
     */
    public boolean checkValidString(String s) {
        int stackLen = 0;
        int availStars = 0;
        int availTailStars = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stackLen++;
            } else if (c == ')') {
                stackLen--;
                if (stackLen < 0) {
                    if (availStars > 0) {
                        stackLen++;
                        availStars--;
                    } else {
                        return false;
                    }
                }
            } else if (c == '*') {
                availStars++;
                availTailStars++;
            }
            availTailStars = Math.min(availTailStars, stackLen);
        }
        return stackLen <= availTailStars;
    }

    public static void main(String[] args) {
        LC678 solution = new LC678();
        System.out.println(solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
