package org.nick.learn.leetcode.p100;

public class P100Solution2 {

    // 深度优先
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
    }

}
