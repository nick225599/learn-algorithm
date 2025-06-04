package org.nick.learn.leetcode.p222;

public class P222Solution1 {

    // 递归
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
