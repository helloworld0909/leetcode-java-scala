package com.helloworld09.leetcode.java;

public class LC165 {
    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     * <p>
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
     * <p>
     * Example 1:
     * <p>
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Example 2:
     * <p>
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * Example 3:
     * <p>
     * Input: version1 = "7.5.2.4", version2 = "7.5.3"
     * Output: -1
     */
    public int compareVersion(String version1, String version2) {
        int[] digits1 = version2digits(version1);
        int[] digits2 = version2digits(version2);

        for (int i = 0; i < Math.min(digits1.length, digits2.length); i++) {
            if (digits1[i] < digits2[i]) {
                return -1;
            } else if (digits1[i] > digits2[i]) {
                return 1;
            }
        }
        return Integer.compare(digits1.length, digits2.length);
    }

    private int[] version2digits(String version) {
        String[] digits = version.split("\\.");
        int end = digits.length - 1;
        while (end > 0 && Integer.valueOf(digits[end]) == 0) {
            end--;
        }
        int[] ret = new int[end + 1];
        for (int i = 0; i <= end; i++) {
            ret[i] = Integer.valueOf(digits[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC165 solution = new LC165();
        System.out.println(solution.compareVersion("19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));
    }
}
