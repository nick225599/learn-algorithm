package org.nick.learn.leetcode.p35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P35Solution1Test {
    private P35Solution1 solution = new P35Solution1();


    @Test
    void searchInsert() {
        int[] nums = new int[]{1,3,5,6};
        assertEquals(1, solution.searchInsert(nums, 2));
    }
}