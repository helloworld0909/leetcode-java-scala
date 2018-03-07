package com.helloworld09.leetcode.java;

import java.util.*;

public class LC451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();

        for (int idx = 0; idx < s.length(); idx++) {
            Character c = s.charAt(idx);
            Integer freq = charFreq.getOrDefault(c, 0);
            charFreq.put(c, ++freq);
        }

        ArrayList<Map.Entry<Character, Integer>> charFreqList = new ArrayList<>(charFreq.entrySet());
        charFreqList.sort((o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        System.out.println(charFreqList);
        StringBuilder sortString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charFreqList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sortString.append(entry.getKey());
            }
        }

        return sortString.toString();
    }

    public static void main(String[] args) {
        LC451 solution = new LC451();
        System.out.println(solution.frequencySort("aaaabbccddd"));
    }
}
