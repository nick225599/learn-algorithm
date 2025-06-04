package org.nick.learn.leetcode.p101;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;
@Slf4j
public class P101Solution1 {

    // 递归
    // 时间复杂度 O(n)
    // 空间复杂度 O(n) （不一定是平衡二叉树，所以不是 O(logn)）
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

}
