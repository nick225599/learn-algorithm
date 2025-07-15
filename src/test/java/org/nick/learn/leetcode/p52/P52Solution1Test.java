package org.nick.learn.leetcode.p52;

import org.junit.jupiter.api.Test;

class P52Solution1Test {
    P52Solution1 solution = new P52Solution1();

    @Test
    void totalNQueens() {
        int result = solution.totalNQueens(5);
        System.out.println(result);
    }
}