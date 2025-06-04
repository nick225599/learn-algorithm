package org.nick.learn.leetcode.p112;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.p100.TreeNode;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

//    Solution1 solution = new Solution1();
Solution2 solution = new Solution2();

    @Test
    void hasPathSum() {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        assertTrue(solution.hasPathSum(root, -5));

    }

    @Test
    void hasPathSum2() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertFalse(solution.hasPathSum(root, 5));
    }
}