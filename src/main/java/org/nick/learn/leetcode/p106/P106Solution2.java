package org.nick.learn.leetcode.p106;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P106Solution2 {

    // in-order: L, val, R
    // post-order: L, R, val
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;

        TreeNode root = new TreeNode(postorder[n - 1]);

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        int inorderIndex = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);

            if (inorder[inorderIndex] == stack.peek().val) {
                TreeNode parent = null;

                // 写成这样就错了， while ( inorder[inorderIndex] == stack.peek().val) {
                while (!stack.isEmpty() && inorder[inorderIndex] == stack.peek().val) {
                    parent = stack.pop();
                    inorderIndex--;
                }
                parent.left = node;
            } else { // 堆栈顶部的元素没有右子树
                stack.peek().right = node;
            }
            stack.push(node);
        }

        return root;
    }


}
