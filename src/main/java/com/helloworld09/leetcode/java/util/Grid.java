package com.helloworld09.leetcode.java.util;

import java.util.*;
import java.util.regex.*;

public class Grid {
    public static int[][] getEnumGrid(int m, int n) {
        if (m <= 0 || n <= 0) {
            System.out.println("m, n should be positive integers");
            return null;
        } else {
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    grid[i][j] = 1 + n * i + j;
            return grid;
        }
    }

    public static int[][] getUniformGrid(int m, int n, int elem) {
        if (m <= 0 || n <= 0) {
            System.out.println("m, n should be positive integers");
            return null;
        } else {
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    grid[i][j] = elem;
            return grid;
        }
    }

    public static int[][] getUniformGrid(int m, int n) {
        return getUniformGrid(m, n, 0);
    }

    public static int[][] getRandomGrid(int m, int n, int bound) {
        Random rnd = new Random();
        if (m <= 0 || n <= 0) {
            System.out.println("m, n should be positive integers");
            return null;
        } else {
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    grid[i][j] = rnd.nextInt(bound);
            return grid;
        }
    }

    public static int[][] getRandomGrid(int m, int n) {
        return getRandomGrid(m, n, m * n);
    }

    public static int[][] parseGrid(String gridStr) {
        Pattern rowPattern = Pattern.compile("\\[([^\\[\\]]+)\\]");
        Matcher rowMatcher = rowPattern.matcher(gridStr);

        int m = 0;
        while (rowMatcher.find())
            m++;
        rowMatcher.reset();

        int[][] grid = new int[m][];
        int i = 0;
        while (rowMatcher.find()) {
            String[] nums = rowMatcher.group(1).trim().split("[, \t\n]+");
            int[] row = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                row[j] = Integer.parseInt(nums[j]);
            }
            grid[i] = row;
            i++;
        }
        return grid;
    }

    public static void printGrid(int[][] grid) {
        for (int[] line : grid) {
            System.out.println(Arrays.toString(line));
        }
    }
}
