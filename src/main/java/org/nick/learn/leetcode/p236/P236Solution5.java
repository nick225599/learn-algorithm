package org.nick.learn.leetcode.p236;

import org.nick.learn.leetcode.p100.TreeNode;

public class P236Solution5 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q)[1];
    }

    // 0 是否包含
    // 1 LCA
    private TreeNode[] dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (null == node) {
            return new TreeNode[2];
        }

        TreeNode[] left = dfs(node.left, p, q);
        if (left[1] != null) {
            return left;
        }

        TreeNode[] right = dfs(node.right, p, q);
        if (right[1] != null) {
            return right;
        }

        if (left[0] != null && right[0] != null) {
            return new TreeNode[]{null, node};
        }
        if ((left[0] != null || right[0] != null)
                && (node.val == p.val || node.val == q.val)) {
            return new TreeNode[]{null, node};
        }

        return new TreeNode[]{
                (left[0] != null || right[0] != null || node.val == p.val || node.val == q.val)
                        ? new TreeNode() : null,
                null
        };
    }
}

