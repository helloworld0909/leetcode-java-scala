package com.helloworld09.leetcode.java;


import java.util.ArrayList;
import java.util.List;

public class LC6 {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1)
            return s;
        StringBuilder buffer = new StringBuilder();
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            List<Integer> indices = convertedIndices(s, numRows, rowIdx);
            for (int idx : indices) {
                buffer.append(s.charAt(idx));
            }
        }
        return buffer.toString();
    }

    private List<Integer> convertedIndices(String s, int numRows, int rowIdx) {
        int cycle = 2 * (numRows - 1);

        List<Integer> indices = new ArrayList<>();
        if (rowIdx == 0 || rowIdx == numRows - 1) {
            for (int idx = rowIdx; idx < s.length(); idx += cycle) {
                indices.add(idx);
            }
        } else {
            for (int idx = 0; idx < s.length(); idx += cycle) {
                int leftIdx = idx + rowIdx;
                int rightIdx = idx + cycle - rowIdx;
                if (leftIdx < s.length())
                    indices.add(leftIdx);
                if (rightIdx < s.length())
                    indices.add(rightIdx);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        LC6 solution = new LC6();
        System.out.println(solution.convert("ABCD", 3));
    }
}
