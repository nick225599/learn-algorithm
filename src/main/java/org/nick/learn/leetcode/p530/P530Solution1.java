package org.nick.learn.leetcode.p530;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P530Solution1 {

    // 中序遍历
    // 时间复杂度O(n)
    // 空间复杂度 O(n)
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        tree2List(root, values);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = Math.abs(values.get(i - 1) - values.get(i));
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    public void tree2List(TreeNode node, List<Integer> values) {
        if (null != node.left) {
            tree2List(node.left, values);
        }
        values.add(node.val);
        if (null != node.right) {
            tree2List(node.right, values);
        }
    }
}
