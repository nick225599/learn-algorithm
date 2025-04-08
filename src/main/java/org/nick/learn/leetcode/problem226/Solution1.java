package org.nick.learn.leetcode.problem226;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution1 {

    /**
     * 递归解法
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(logn)
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (null != root.left) {
            root.left = invertTree(root.left);
        }

        if (null != root.right) {
            root.right = invertTree(root.right);
        }

        return root;
    }
}
