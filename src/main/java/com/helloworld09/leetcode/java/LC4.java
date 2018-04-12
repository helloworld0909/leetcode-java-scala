package com.helloworld09.leetcode.java;


public class LC4 {
    //TODO: Not Finished
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return getMedian(nums2);
        if (nums2.length == 0)
            return getMedian(nums1);
        return findMedianAuxiliary(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }

    private double findMedianAuxiliary(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2) {

        int mid1 = (begin1 + end1) / 2;
        int mid2 = (begin2 + end2) / 2;

        int len1 = end1 - begin1;
        int len2 = end2 - begin2;

        int midElem1 = nums1[mid1];
        int midElem2 = nums2[mid2];

        if (len1 == 1 || len2 == 1) {
            return (midElem1 + midElem2) / 2.0;
        }

        if (midElem1 == midElem2) {
            return midElem1;
        } else if (midElem1 < midElem2) {
            return findMedianAuxiliary(nums1, mid1, end1, nums2, begin2, mid2);
        } else {
            return findMedianAuxiliary(nums1, begin1, mid1, nums2, mid2, end2);
        }
    }

    private double getMedian(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        if (len % 2 == 0)
            return (nums[mid - 1] + nums[mid]) / 2.0;
        else
            return nums[mid];
    }

    public static void main(String[] args) {
        LC4 solution = new LC4();
        int[] input1 = {1, 3};
        int[] input2 = {2};
        System.out.println(solution.findMedianSortedArrays(input1, input2));
    }
}
