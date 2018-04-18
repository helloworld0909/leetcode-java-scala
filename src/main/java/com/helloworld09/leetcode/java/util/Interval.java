package com.helloworld09.leetcode.java.util;

import java.util.*;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", start, end);
    }

    public static List<Interval> getIntervalList(int... inputList) {
        List<Interval> ret = new ArrayList<>();
        if (inputList.length % 2 != 0) {
            System.out.println("Num of input params should be even");
            return ret;
        } else {
            for (int i = 0; i < inputList.length; i += 2) {
                int start = inputList[i];
                int end = inputList[i + 1];
                if (start > end) {
                    int tmp = start;
                    start = end;
                    end = tmp;
                }
                ret.add(new Interval(start, end));
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(getIntervalList(1, 2, 4, 5));
    }
}
