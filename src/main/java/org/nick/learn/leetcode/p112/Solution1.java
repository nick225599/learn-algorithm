package org.nick.learn.leetcode.p112;

import org.nick.learn.leetcode.p226.TreeNode;

public class Solution1 {
    // 深度优先，回溯算法

    // 时间复杂度 O(n) 每个节点只会被遍历一次
    // 空间复杂度 O(n)
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (null == node) return false;

        int sum = 0;

        // 放入当前节点
        sum += node.val;
        if(null == node.left && null == node.right){
            return sum == targetSum;
        }

        // 放入左节点
        boolean b = hasPathSum(node.left, targetSum - sum);
        if (b) {
            return true;
        }

        // 放入右节点
        return hasPathSum(node.right, targetSum - sum);
    }
}
