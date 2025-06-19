package org.nick.learn.leetcode.p173;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
public class P173Solution3 {
    // in-order: left, val, right
    // 进阶：
    //
    //你可以设计一个满足下述条件的解决方案吗？
    // next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，
    // 并使用 O(h) 内存。其中 h 是树的高度。
    //
    // 写不出来
    public static class BSTIterator {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node;

        public BSTIterator(TreeNode root) {
            node = root;
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
        }


        public int next() {
            int val = node.val;

            node = node.right;
            if (null != node) {
                while (node.left != null) {
                    stack.push(node);
                    node = node.left;
                }
            } else if (!stack.isEmpty()) {
                node = stack.pop();
            }


            return val;
        }

        public boolean hasNext() {
            return node != null;
        }
    }
}
