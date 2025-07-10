package org.nick.learn.leetcode.p77;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P77Solution1Test {
    P77Solution1 solution = new P77Solution1();

    @Test
    void combine() {
        List<List<Integer>> result = solution.combine(4, 2);
        for(List<Integer> pair : result){
            System.out.println(Arrays.toString(pair.stream().toArray()));
        }
    }
}