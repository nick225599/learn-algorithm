package org.nick.learn.leetcode.p114;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P114Solution2 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> list = new LinkedList<>();
        this.tree2list(root, list);

        TreeNode pre = new TreeNode();
        for (TreeNode cur : list) {
            pre.left = null;
            pre.right = cur;
            pre = cur;
        }
        pre.left = null;
        pre.right = null;

    }

    private void tree2list(TreeNode node, List<TreeNode> list) {
        list.add(node);
        if (node.left != null) {
            tree2list(node.left, list);
        }
        if (node.right != null) {
            tree2list(node.right, list);
        }
    }
}
