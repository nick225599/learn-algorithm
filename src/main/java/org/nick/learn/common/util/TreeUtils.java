package org.nick.learn.common.util;

import org.nick.learn.leetcode.p100.TreeNode;

public class TreeUtils {
    private TreeUtils() {
    }

    // cur, left , right
    public static String preOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (null != root.left) {
            sb.append(",").append(preOrder(root.left));
        }
        if (null != root.right) {
            sb.append(",").append(preOrder(root.right));
        }
        return sb.toString();
    }

    // left, cur, left
    public static String inOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(null != root.left){
            sb.append(inOrder(root.left));
        }
        sb.append(",");
        sb.append(root.val);
        if (null != root.right) {
            sb.append(",").append(inOrder(root.right));
        }
        return sb.toString();
    }
}
