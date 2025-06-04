package org.nick.learn.leetcode.p222;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    TreeNode(int val, int leftVal, int rightVal) {
        this.val = val;
        this.left = new TreeNode(leftVal);
        this.right = new TreeNode(rightVal);
    }


}
