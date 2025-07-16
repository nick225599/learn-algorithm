package org.nick.learn.leetcode.p79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class P79Solution1Test {

    P79Solution1 solution = new P79Solution1();

    @Test
    void exist() {
        char[][] board = new char[][]{
                {'a'},
                {'a'}
        };
        assertFalse(solution.exist(board, "aaa"));
    }
}