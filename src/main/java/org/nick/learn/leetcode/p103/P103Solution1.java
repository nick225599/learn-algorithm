package org.nick.learn.leetcode.p103;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P103Solution1 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<TreeNode> top = new ArrayList<>(Collections.singletonList(root));
        int level = 0;

        List<List<Integer>> result = new ArrayList<>();
        this.bfs(result, top, level);
        return result;
    }

    private void bfs(List<List<Integer>> result, List<TreeNode> list, int level) {
        if (list.isEmpty()) {
            return;
        }
        List<Integer> values = new ArrayList<>(list.size());
        List<TreeNode> nextLevel = new ArrayList<>(list.size() * 2); // 比 dfs 多一个数组创建和销毁的 gc 压力
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            values.add(node.val);
            if (level % 2 == 0) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }
        }
        result.add(values);

        bfs(result, nextLevel, level + 1);

    }
}
