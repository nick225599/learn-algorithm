package org.nick.learn.leetcode.problem88;


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexOfNums1 = m - 1;
        int indexOfNums2 = n - 1;
        int indexOfFill = m + n - 1;
        while (indexOfFill >= 0) {
            if (indexOfNums1 < 0) {
                nums1[indexOfFill] = nums2[indexOfNums2--];
            } else if (indexOfNums2 < 0) {
                nums1[indexOfFill] = nums1[indexOfNums1--];
            } else if (nums1[indexOfNums1] < nums2[indexOfNums2]) {
                nums1[indexOfFill] = nums2[indexOfNums2--];
            } else {
                nums1[indexOfFill] = nums1[indexOfNums1--];
            }
            indexOfFill--;
        }
    }

    public static void main(String[] args) {

    }
}
