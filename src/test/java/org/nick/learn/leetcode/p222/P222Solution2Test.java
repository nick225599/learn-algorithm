package org.nick.learn.leetcode.p222;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P222Solution2Test {
    P222Solution2 solution = new P222Solution2();

    // 1      0
    // 2    1    2
    // 3  3 4   5 6
    @Test
    void countNodes() {
        TreeNode node = new TreeNode(0,
                new TreeNode(1, 3, 4),
                new TreeNode(2, 5, 6));
        assertEquals(7, solution.countNodes(node));
    }

    @Test
    void exist() {
    }
}