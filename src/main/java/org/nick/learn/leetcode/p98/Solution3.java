package org.nick.learn.leetcode.p98;

import org.nick.learn.leetcode.p226.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    // 前序 先读当前节点，再读它地左节点，再读它的右节点，数据无序
    public boolean isValidBST1(TreeNode node) {
        return false;
    }

    // 中序 先读左节点，再读自身，再读右节点，有序
    // 时间复杂度还是 O(n) 空间复杂度还是 O(n) 常数项比 Solution 2 都高，
    // 看看官方题解是怎么用迭代取代递归的
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

    // 后序 先读左节点，再读右节点，再读自身，无需
    public boolean isValidBST3(TreeNode node) {
        return false;
    }


}
