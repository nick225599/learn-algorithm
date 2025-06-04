package org.nick.learn.leetcode.p226;


import org.nick.learn.leetcode.p100.TreeNode;

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
     * 空间复杂度 O(logn)，错了，是 O(N) 最坏情况下二叉树变成了链表，树高度等于元素个数 N
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
