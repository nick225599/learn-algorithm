package org.nick.learn.leetcode.p105;

import org.junit.jupiter.api.Test;
import org.nick.learn.common.util.TreeUtils;
import org.nick.learn.leetcode.p100.TreeNode;

class P105Solution1Test {
    P105Solution1 solution = new P105Solution1();

    @Test
    void buildTree() {
        TreeNode root = solution.buildTree(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7}
                );
        System.out.println(TreeUtils.preOrder(root));
        System.out.println(TreeUtils.inOrder(root));
    }
}