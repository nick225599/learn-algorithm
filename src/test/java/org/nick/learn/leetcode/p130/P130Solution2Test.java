package org.nick.learn.leetcode.p130;

import org.junit.jupiter.api.Test;

class P130Solution2Test {


    @Test
    void solve() {
        P130Solution2 solution = new P130Solution2();
        char[][] board = new char[][]{
                new char[]{'O'},
        };
        solution.solve(board);
        System.out.println(solution.times);

        solution = new P130Solution2();
        board = new char[][]{
                new char[]{'O', 'O'},
                new char[]{'O', 'O'},
        };
        solution.solve(board);
        System.out.println(solution.times);

        solution = new P130Solution2();
        board = new char[][]{
                new char[]{'O', 'O', 'O'},
                new char[]{'O', 'O', 'O'},
                new char[]{'O', 'O', 'O'},
        };
        solution.solve(board);
        System.out.println(solution.times);

        solution = new P130Solution2();
        board = new char[][]{
                new char[]{'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O'},
        };
        solution.solve(board);
        System.out.println(solution.times);

        solution = new P130Solution2();
        board = new char[][]{
                new char[]{'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O'},
        };
        solution.solve(board);
        System.out.println(solution.times);
    }

//    1. 4
//    4 16
//    9 36
//    16 64
//    25 100
}