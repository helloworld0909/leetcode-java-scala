package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.Interval;

public class LC56 {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        List<Interval> ret = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int next = i + 1;
            int newEnd = interval.end;
            while (next < intervals.size() && newEnd >= intervals.get(next).start) {
                newEnd = Math.max(newEnd, intervals.get(next).end);
                next++;
            }
            ret.add(newEnd == interval.end ? interval : new Interval(interval.start, newEnd));
            i = next - 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(3, 6));
        input.add(new Interval(1, 3));

        LC56 solution = new LC56();
        System.out.println(solution.merge(input));
    }
}
