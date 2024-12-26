package org.nick.learn.leetcode.problems88;

import org.junit.Assert;

import java.util.Arrays;

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
        Solution solution = new Solution();
        int[] nums1, nums2;
        int m, n;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[]{2, 5, 6};
        n = 3;
        solution.merge(nums1, m, nums2, n);
        Assert.assertEquals("[1, 2, 2, 3, 5, 6]", Arrays.toString(nums1));

    }
}
