package org.nick.learn.leetcode.problem98;

import org.nick.learn.leetcode.problem226.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    // 中序遍历，不用递归
    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        Queue<TreeNode> deque = new LinkedList<>();
        putBSTIntoQueue(root, deque);
        TreeNode node = deque.poll();
        int preVal = node.val;
        while ((node = deque.poll()) != null) {
            if (preVal >= node.val) {
                return false;
            }
            preVal = node.val;
        }
        return true;
    }

    private void putBSTIntoQueue(TreeNode node, Queue<TreeNode> deque) {
        if (null == node) return;
        putBSTIntoQueue(node.left, deque);
        deque.add(node);
        putBSTIntoQueue(node.right, deque);
    }



}
