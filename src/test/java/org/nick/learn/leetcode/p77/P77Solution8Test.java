package org.nick.learn.leetcode.p77;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
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
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            solution8.combine(i, 3);
        }
        long end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            solution10.combine(i, 3);
        }
        end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));
    }

    @Test
    void combine3() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            solution8.combine(i, 3);
        }
        long end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            solution10.combine(100, 3);
        }
        end = System.currentTimeMillis();
        System.out.println("elapse: " + (end - start));
    }
}