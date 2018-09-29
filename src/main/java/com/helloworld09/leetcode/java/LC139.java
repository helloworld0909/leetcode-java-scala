package com.helloworld09.leetcode.java;

import java.util.*;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] hasBreak = new boolean[s.length() + 1];
        hasBreak[0] = true;
        for (int i = 1; i < hasBreak.length; i ++) {
            for (String word : wordDict) {
                if (word.length() > i) {
                    continue;
                }
                if (hasBreak[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    hasBreak[i] = true;
                    break;
                }
            }
        }
        return hasBreak[hasBreak.length - 1];
    }

    public static void main(String[] args) {
        LC139 solution = new LC139();
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
