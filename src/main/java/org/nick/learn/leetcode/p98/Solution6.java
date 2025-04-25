package org.nick.learn.leetcode.p98;

import org.nick.learn.leetcode.p226.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {

    // 中序遍历，不用递归
    // 时间复杂度 空间复杂度 也都还是 O(n)
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode curNode = root;
        TreeNode preNode = null;

        // 这个写法太巧妙了，咋记得住
        while (!queue.isEmpty() || null != curNode) {

            // 将当前节点的左节点一点点往栈内压，直到压入最后一个左节点
            while (null != curNode) {
                queue.push(curNode);
                curNode = curNode.left;
            }

            // 处理当前节点
            curNode = queue.pop();
            if (null != preNode && preNode.val >= curNode.val) {
                return false;
            }

            // 继续遍历下一个节点
            preNode = curNode;
            curNode = curNode.right;
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
