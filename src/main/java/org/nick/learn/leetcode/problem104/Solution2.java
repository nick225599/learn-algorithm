package org.nick.learn.leetcode.problem104;

import org.nick.learn.leetcode.problem226.TreeNode;

public class Solution2 {

    /**
     * 基于 org.nick.learn.leetcode.problem104.Solution1 简化代码
     * 时间复杂度 空间复杂度 依然都是 O(n)
     * @see Solution1
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
