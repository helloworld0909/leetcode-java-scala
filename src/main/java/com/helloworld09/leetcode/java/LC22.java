package com.helloworld09.leetcode.java;


import java.util.ArrayList;
import java.util.List;

public class LC22 {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * For example, given n = 3, a solution set is:
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0){
            ret.add("");
            return ret;
        }
        for (int i = 0; i < n; i++) {
            for (String p1 : generateParenthesis(i)) {
                for (String p2 : generateParenthesis(n - 1 - i))
                    ret.add("(" + p1 + ")" + p2);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC22 solution = new LC22();
        System.out.println(solution.generateParenthesis(3));
    }
}
