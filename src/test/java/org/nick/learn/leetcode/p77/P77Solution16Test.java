package org.nick.learn.leetcode.p77;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class P77Solution16Test {
    P77Solution16 solution = new P77Solution16();

    @Test
    void combine() {
        List<List<Integer>> result = solution.combine(3, 2);
        for (List<Integer> ans : result) {
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}