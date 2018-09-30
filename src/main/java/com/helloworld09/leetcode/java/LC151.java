package com.helloworld09.leetcode.java;

import java.util.Arrays;

public class LC151 {
    /**
     * Given an input string, reverse the string word by word.
     * <p>
     * Example:
     * <p>
     * Input: "the sky is blue",
     * Output: "blue is sky the".
     * Note:
     * <p>
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     * Follow up: For C programmers, try to solve it in-place in O(1) space.
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        // Remove multiple spaces between two words
        int i = 0, j = 0;
        while (i < chars.length) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            while (i < chars.length && chars[i] != ' ') {
                chars[j++] = chars[i++];
            }
            if (j < chars.length) {
                chars[j++] = ' ';
            }
        }
        chars = Arrays.copyOfRange(chars, 0, j);

        int begin = 0;
        for (i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, begin, i - 1);
                begin = i + 1;
            }
        }
        reverse(chars, 0, chars.length - 1);
        return new String(chars).trim();
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        LC151 solution = new LC151();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
