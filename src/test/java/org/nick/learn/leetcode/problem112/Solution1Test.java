package org.nick.learn.leetcode.problem112;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.problem226.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    Solution1 solution = new Solution1();

    @Test
    void hasPathSum() {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        assertTrue(solution.hasPathSum(root, -5));

    }
}