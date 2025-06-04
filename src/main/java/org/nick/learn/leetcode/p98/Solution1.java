package org.nick.learn.leetcode.p98;

import org.nick.learn.leetcode.p100.TreeNode;
public class Solution1 {
    public boolean isValidBST(TreeNode node) {
        boolean b = true;
        // 有效 二叉搜索树定义如下：
        //
        // 节点的左子树只包含 小于 当前节点的数。
        if (null != node.left) {
            b = allChildLessThan(node.left, node.val);
        }

        // 节点的右子树只包含 大于 当前节点的数。
        if (null != node.right) {
            b = b && allChildGreaterThan(node.right, node.val);
        }

        // 所有左子树和右子树自身必须也是二叉搜索树。
        if(null != node.left){
            b = b && isValidBST(node.left);
        }
        if(null != node.right){
            b = b && isValidBST(node.right);
        }

        return b;
    }

    private boolean allChildLessThan(TreeNode node, int targetVal) {
        if (null == node) return true;
        return node.val < targetVal
                && allChildLessThan(node.left, targetVal)
                && allChildLessThan(node.right, targetVal);

    }

    private boolean allChildGreaterThan(TreeNode node, int targetVal) {
        if (null == node) return true;
        return targetVal < node.val
                && allChildGreaterThan(node.left, targetVal)
                && allChildGreaterThan(node.right, targetVal);
    }

}
