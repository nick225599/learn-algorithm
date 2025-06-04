package org.nick.learn.leetcode.p222;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.p100.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P222Solution2Test {
    P222Solution2 solution = new P222Solution2();

    // 1      1
    // 2    2    3
    // 3  4 5   6 7
    @Test
    void countNodes() {
        TreeNode node = new TreeNode(1,
                new TreeNode(2, 4, 5),
                new TreeNode(3, 6, 7));
        assertEquals(7, solution.countNodes(node));
    }

    @Test
    void exist() {
    }
}