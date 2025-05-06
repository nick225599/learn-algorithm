package org.nick.learn.leetcode.p55;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class P55Solution2Test {
    private P55Solution2 solution = new P55Solution2();

    @Test
    public void testCanJump() {
        List<Integer> l = new ArrayList<>();
        for (int i = 9997; i >= 0; i--) {
            l.add(i);
        }
        l.add(0);
        int[] nums = l.stream().mapToInt(Integer::intValue).toArray();
        boolean b = solution.canJump(nums);
        assertFalse(b);
    }

    @Test
    public void testCanJump2() {
        int[] nums = new int[]{1, 0, 0};
        boolean b = solution.canJump(nums);
        assertFalse(b);
    }
}