package org.nick.learn.leetcode.p173;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
public class P173Solution2 {
    // in-order: left, val, right
    // 进阶：
    //
    //你可以设计一个满足下述条件的解决方案吗？
    // next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，
    // 并使用 O(h) 内存。其中 h 是树的高度。
    //
     // 写不出来
    static class BSTIterator {
        Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (true) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    break;
                }
            }
        }


        public int next() {
            TreeNode node = stack.pop();
            TreeNode nextNode = stack.peek();
            if (node.right == nextNode) {
                TreeNode tmp = stack.pop();
                while (true) {
                    if (tmp.right != null) {
                        stack.push(tmp.right);
                    }
                    stack.push(tmp);
                    if (tmp.left != null) {
                        stack.push(tmp.left);
                    } else {
                        break;
                    }
                }
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
