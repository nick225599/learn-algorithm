package org.nick.learn.leetcode.p230;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.p100.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P230Solution1Test {
    P230Solution1 solution = new P230Solution1();

    @Test
    void kthSmallest() {
        // [3,1,4,null,2]
        //
        //          3
        //      1       4
        //  null   2
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)
        );
        assertEquals(1, solution.kthSmallest(root, 1));
        assertEquals(2, solution.kthSmallest(root, 2));
        assertEquals(3, solution.kthSmallest(root, 3));
        assertEquals(4, solution.kthSmallest(root, 4));
    }
}