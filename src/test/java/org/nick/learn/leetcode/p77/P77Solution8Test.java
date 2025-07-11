package org.nick.learn.leetcode.p77;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P77Solution8Test {
    P77Solution8 solution = new P77Solution8();

    P77Solution8 solution8 = new P77Solution8();
    P77Solution10 solution10 = new P77Solution10();

    @Test
    void combine() {
        List<List<Integer>> ans = solution.combine(3, 2);

        // [1, 2] [1, 3] [2, 3]
        for (List<Integer> tmp : ans) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }

    @Test
    void combine2() {
        int[] arr = new int[100];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            List<List<Integer>> ans = solution8.combine(i, 3);
            arr[i] = ans.size();
        }
        long end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            List<List<Integer>> ans = solution10.combine(i, 3);
            assertEquals(arr[i], ans.size());
        }
        end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));
    }
}