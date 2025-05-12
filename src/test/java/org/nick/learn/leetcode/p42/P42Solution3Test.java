package org.nick.learn.leetcode.p42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P42Solution3Test {
    P42Solution3 solution = new P42Solution3();

    @Test
    void trap() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = solution.trap(height);
        Assertions.assertEquals(6, sum);
    }

    @Test
    void trap2() {
        int[] height = new int[]{4,2,0,3,2,5};
        int sum = solution.trap(height);
        Assertions.assertEquals(9, sum);
        //TODO nick 栈方法哪里没写对
    }

}