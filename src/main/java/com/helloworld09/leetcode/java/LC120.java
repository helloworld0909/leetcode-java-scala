package com.helloworld09.leetcode.java;

import java.util.*;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size() - 1; i++) {
            List<Integer> preRow = triangle.get(i);
            List<Integer> row = triangle.get(i + 1);
            row.set(0, row.get(0) + preRow.get(0));
            row.set(row.size() - 1, row.get(row.size() - 1) + preRow.get(preRow.size() - 1));
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + Math.min(preRow.get(j - 1), preRow.get(j)));
            }
        }
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int minSum = lastRow.get(0);
        for (int elem : lastRow) {
            if (elem < minSum) {
                minSum = elem;
            }
        }
        return minSum;
    }

    public static void main(String[] args) {

    }
}
