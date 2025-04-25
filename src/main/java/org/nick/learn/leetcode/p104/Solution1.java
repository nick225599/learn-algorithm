package org.nick.learn.leetcode.p104;

import org.nick.learn.leetcode.p226.TreeNode;

public class Solution1 {

    /**
     * 递归解法，跟力扣 226. 镜像翻转二叉树 一样的处理逻辑
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.left, 1);
        int rightDepth = maxDepth(root.right, 1);
        return Math.max(leftDepth, rightDepth);
    }

    private int maxDepth(TreeNode node, int i) {
        if (null == node) {
            return i;
        }
        int leftDepth = maxDepth(node.left, i + 1);
        int rightDepth = maxDepth(node.right, i + 1);
        return Math.max(leftDepth, rightDepth);
    }


}
