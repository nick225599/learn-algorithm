package org.nick.learn.leetcode.p102;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P102Solution2 {

    // 比 fbs 快...
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        this.dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (null == node) {
            return;
        }

        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        dfs(result, node.left, level + 1);
        dfs(result, node.right, level + 1);
    }
}
