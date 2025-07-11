package org.nick.learn.leetcode.p77;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class P77Solution8Test {

    P77Solution8 solution = new P77Solution8();

    @Test
    void combine() {
        List<List<Integer>> ans = solution.combine(3, 2);

        // [1, 2] [1, 3] [2, 3]
        for (List<Integer> tmp : ans) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }
}