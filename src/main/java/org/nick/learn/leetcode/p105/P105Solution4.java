package org.nick.learn.leetcode.p105;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P105Solution4 {


    // AI 写出来的
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[0]);
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            int inorderIndex = 0;

            for (int i = 1; i < preorder.length; i++) {
                TreeNode node = new TreeNode(preorder[i]);
                TreeNode parent = null;

                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    parent = stack.pop();
                    inorderIndex++;
                }

                if (parent != null) {
                    parent.right = node;
                } else {
                    stack.peek().left = node;
                }

                stack.push(node);
            }

            return root;
        }


}
