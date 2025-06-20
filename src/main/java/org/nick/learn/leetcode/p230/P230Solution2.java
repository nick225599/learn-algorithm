package org.nick.learn.leetcode.p230;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P230Solution2 {

    // 纯迭代
    public int kthSmallest(TreeNode cur, int k) {
        // in-order: left, val, right
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        throw new RuntimeException();
    }



}
