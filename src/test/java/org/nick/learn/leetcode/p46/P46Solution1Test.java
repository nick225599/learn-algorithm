package org.nick.learn.leetcode.p46;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P46Solution1Test {
    P46Solution1 solution = new P46Solution1();

    @Test
    void permute() {
        List<List<Integer>> result = solution.permute(new int[]{1,2,3});
        for(List<Integer> list: result){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}