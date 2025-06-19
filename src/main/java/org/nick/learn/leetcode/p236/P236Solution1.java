package org.nick.learn.leetcode.p236;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P236Solution1 {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 深度搜索找到 p 的父节点
        List<TreeNode> parentsOfP = this.dfs(root, p);

        // 深度搜索找到 q 的父节点
        List<TreeNode> parentsOfQ = this.dfs(root, q);

        // 找到最深的公共父节点
        TreeNode node = null;
        for (int i = 0; i < Math.min(parentsOfP.size(), parentsOfQ.size()); i++) {
            if (parentsOfP.get(i).equals(parentsOfQ.get(i))) {
                node = parentsOfP.get(i);
            } else {
                break;
            }
        }
        return node;
    }

    private List<TreeNode> dfs(TreeNode node, TreeNode target) {
        List<TreeNode> list = new LinkedList<>();
        dfs(node, target, list);
        return list;
    }

    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> list) {
        if (node == null) {
            return false;
        }
        if (node.equals(target)) {
            list.add(node);
            return true;
        }
        list.add(node);
        boolean b = dfs(node.left, target, list) || dfs(node.right, target, list);
        if(!b){
            list.removeLast();
            return false;
        }
        return true;
    }

}
