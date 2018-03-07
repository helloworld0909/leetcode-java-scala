package com.helloworld09.leetcode.java;


public class LC678 {
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
//            System.out.println(Arrays.asList(stackLen, availStars, availTailStars));
        }
        return stackLen <= availTailStars;
    }

    public static void main(String[] args) {
        LC678 solution = new LC678();
        System.out.println(solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
