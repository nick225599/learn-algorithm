package org.nick.learn.leetcode.p88;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void merge() {
        Solution solution = new Solution();
        int[] nums1, nums2;
        int m, n;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[]{2, 5, 6};
        n = 3;
        solution.merge(nums1, m, nums2, n);
        org.junit.jupiter.api.Assertions.assertEquals("[1, 2, 2, 3, 5, 6]", Arrays.toString(nums1));

    }
}