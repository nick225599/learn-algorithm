package org.nick.learn.leetcode.p173;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class P173Solution2 {
    // 进阶：
    //
    //你可以设计一个满足下述条件的解决方案吗？
    // next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，
    // 并使用 O(h) 内存。其中 h 是树的高度。
    static class BSTIterator {
        Deque<TreeNode> stack = new LinkedList<>();
TreeNode node;
        public BSTIterator(TreeNode root) {
            node = root;
            while(node.left != null){
                stack.push(node);
                node = node.left;
            }
        }



        public int next() {
            int result = node.val;



            return result;
        }

        public boolean hasNext() {
            return node != null;
        }
    }
}
