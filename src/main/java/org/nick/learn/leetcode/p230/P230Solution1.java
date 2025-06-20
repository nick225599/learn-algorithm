package org.nick.learn.leetcode.p230;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P230Solution1 {

    public int kthSmallest(TreeNode root, int k) {
        // in-order: left, val, right
        Deque<TreeNode> stack = new ArrayDeque<>();
        return kthSmallest(root, k, 0, stack);
    }

    // 这也不知道叫啥迭代方法好......
    public Integer kthSmallest(TreeNode node, int k, int index, Deque<TreeNode> stack) {
        TreeNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        index++;
        if (index == k) {
            return cur.val;
        }
        cur = cur.right;
        return kthSmallest(cur, k, index, stack);
    }

}
