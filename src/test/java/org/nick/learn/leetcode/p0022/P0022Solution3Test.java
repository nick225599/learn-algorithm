package org.nick.learn.leetcode.p0022;

import org.junit.jupiter.api.Test;

import java.util.List;

class P0022Solution3Test {
    P0022Solution3 solution = new P0022Solution3();

    @Test
    void generateParenthesis() {
        List<String> list = solution.generateParenthesis(3);
        for (String str : list) {
            System.out.println(str);
        }
    }
}