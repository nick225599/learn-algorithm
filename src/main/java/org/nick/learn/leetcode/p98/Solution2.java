package org.nick.learn.leetcode.p98;

import org.nick.learn.leetcode.p226.TreeNode;

public class Solution2 {

    // 官方题解能将每个节点的遍历次数降低到 1
    // 我也试试
    // 时间复杂度 O(n)
    // 空间复杂度 O(n) 栈空间
    public boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (null == node) return true;
        if (null != node.left && node.left.val >= node.val) return false;
        if (null != node.right && node.right.val <= node.val) return false;
        if (node.val <= minValue || node.val >= maxValue) return false;
        return isValidBST(node.left, minValue, node.val)
                && isValidBST(node.right, node.val, maxValue);
    }


}
