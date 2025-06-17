package org.nick.learn.leetcode.p114;

import org.nick.learn.leetcode.p100.TreeNode;

public class P114Solution3 {

    // 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
    // 只能是迭代
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {

            // 把当前的右节点挂到左节点的右边去
            if(cur.left != null){
                TreeNode node = cur.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
                continue;
            }

            cur = cur.right;
        }
    }


}
