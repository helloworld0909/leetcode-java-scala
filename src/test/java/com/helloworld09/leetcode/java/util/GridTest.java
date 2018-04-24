package com.helloworld09.leetcode.java.util;

import org.junit.Test;
import org.junit.Assert;

public class GridTest {

    @Test
    public void parseGridTest() {

        Assert.assertArrayEquals(Grid.parseGrid(""), new int[][]{});

        int[][] grid = {
                new int[]{1, 0, 0},
                new int[]{1, 0, 1},
                new int[]{1, 1, 0}
        };
        String[] testFormats = {
                "[[1,0,0],[1,0,1],[1,1,0]]",
                "[\n[1, 0, 0]\n,[1, 0, 1]\n,[1, 1, 0]\n]",
                "[[1],[1,0,1],[1,1]]",
        };
        for (String format: testFormats)
            Assert.assertArrayEquals(Grid.parseGrid(format), grid);
    }
}
