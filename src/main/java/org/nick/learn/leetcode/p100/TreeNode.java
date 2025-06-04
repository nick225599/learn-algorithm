package org.nick.learn.leetcode.p100;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, int leftVal, int rightVal) {
        this.val = val;
        this.left = new TreeNode(leftVal);
        this.right = new TreeNode(rightVal);
    }
}
