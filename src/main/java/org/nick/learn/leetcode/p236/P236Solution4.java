package org.nick.learn.leetcode.p236;

import org.nick.learn.leetcode.p100.TreeNode;

public class P236Solution4 {

    //    在递归中，方法 lowestCommonAncestor(...) 的返回值可以有以下两种语义：
    //
    //    含义 1：当前子树中找到了 p 或 q 中的一个节点
    //      当前递归调用返回的是 p 或 q 节点本身。
    //      比如当某个子树中只包含 p，而不包含 q，那么递归会一直向上返回 p 节点。
    //    含义 2：当前节点就是 LCA（最近公共祖先）
    //      如果一个节点的左右子树分别找到了 p 和 q（即 n1 != null && n2 != null），
    //      那说明当前节点就是 LCA，所以返回它自己。

    // 违反了单一职责，看着有点脑壳疼
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode n1 = lowestCommonAncestor(root.left, p, q);
        TreeNode n2 = lowestCommonAncestor(root.right, p, q);
        if (null != n1 && null != n2) {
            return root;
        }
        return null != n1 ? n1 : n2;
    }
}

