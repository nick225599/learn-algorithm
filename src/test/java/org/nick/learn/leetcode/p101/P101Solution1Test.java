package org.nick.learn.leetcode.p101;

import org.junit.jupiter.api.Test;

class P101Solution1Test {
    P101Solution1 solution = new P101Solution1();

    @Test
    void isSymmetric() {
        // root = [1,
        //       2,   2,
        //      3,4, 4,3]
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        solution.isSymmetric(root);
    }
}