package org.nick.learn.leetcode.p530;

import org.nick.learn.leetcode.p100.TreeNode;

public class P530Solution2 {
    private Integer preVal = null;
    private int minDiff = Integer.MAX_VALUE;


    // 中序遍历
    // 时间复杂度 O(n)
    // 空间复杂度 O(n) 栈依旧有空间损耗
    public int getMinimumDifference(TreeNode node) {
        if (null != node.left) {
            minDiff = Math.min(minDiff, getMinimumDifference(node.left));
        }
        if (null != preVal) {
            int diff = Math.abs(preVal - node.val);
            minDiff = Math.min(minDiff, diff);
        }
        preVal = node.val;
        if (null != node.right) {
            minDiff = Math.min(minDiff, getMinimumDifference(node.right));
        }
        return minDiff;
    }


}
