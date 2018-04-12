package com.helloworld09.leetcode.java;

import java.util.*;

public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charLastFoundIndex = new HashMap<>();
        int maxLength = 0, leftIdx = -1;
        for (int idx = 0; idx < s.length(); idx++) {
            Character c = s.charAt(idx);
            if (charLastFoundIndex.containsKey(c)) {
                int collideIdx = charLastFoundIndex.get(c);
                leftIdx = Math.max(leftIdx, collideIdx);
            }
            maxLength = Math.max(maxLength, idx - leftIdx);
            charLastFoundIndex.put(c, idx);
        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcddefghg"));
    }
}
