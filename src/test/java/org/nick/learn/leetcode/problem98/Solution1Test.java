package org.nick.learn.leetcode.problem98;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.problem226.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution1Test {

    Solution2 solution = new Solution2();

    @Test
    void isValidBST() {
        // [5,4,6,null,null,3,7]
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node6 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode root = new TreeNode(5, node4, node6);

        assertFalse(solution.isValidBST(root));

    }

    @Test
    void isValidBST2() {
        // [2,1,3]
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertTrue(solution.isValidBST(root));

    }


    @Test
    void isValidBST3() {
        // [2147483647], true
        TreeNode root = new TreeNode(2147483647);
        assertTrue(solution.isValidBST(root));

    }
}