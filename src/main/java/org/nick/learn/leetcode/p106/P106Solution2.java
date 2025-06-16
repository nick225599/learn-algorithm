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

            // 判断栈顶节点是不是没有右子树
            if (inorder[inorderIndex] != stack.peek().val) { // 堆栈顶部的元素没有右子树
                // 有右子树
                stack.peek().right = node;
            } else {
                // 没有右子树

                // 没有右子树的话，那么当前元素就是栈顶元素或者栈顶元素的某个父元素的左子树
                TreeNode parent = null;

                // 根据中序和后续的逆序性来跳过没有左节点的栈顶元素

                // 写成这样就错了， while ( inorder[inorderIndex] == stack.peek().val) {
                while (!stack.isEmpty() && inorder[inorderIndex] == stack.peek().val) {
                    parent = stack.pop();
                    inorderIndex--;
                }
                parent.left = node;
            }
            stack.push(node);
        }

        return root;
    }


}
