package org.nick.learn.leetcode.p100;

public class P100Solution1 {

    // 一遍过
    // 深度有限
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        }

        if (p.left != null && q.left == null) {
            return false;
        }
        if (p.left == null && q.left != null) {
            return false;
        }
        if (p.left != null && q.left != null && p.left.val != q.left.val) {
            return false;
        }

        if (p.right != null && q.right == null) {
            return false;
        }
        if (p.right == null && q.right != null) {
            return false;
        }
        if (p.right != null && q.right != null && p.right.val != q.right.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }

}
