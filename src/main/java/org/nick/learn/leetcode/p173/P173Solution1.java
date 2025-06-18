package org.nick.learn.leetcode.p173;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P173Solution1 {


    static class BSTIterator {
        Queue<TreeNode> queue = new LinkedList<>();

        // 时间复杂度 O(n)
        // 空间复杂度 O(n)
        public BSTIterator(TreeNode root) {
            this.queue(queue, root);
        }

        private void queue(Queue<TreeNode> queue, TreeNode root) {
            if(null == root){
                return;
            }
            queue(queue, root.left);
            queue.offer(root);
            queue(queue, root.right);
        }


        public int next() {
            TreeNode node = queue.poll();
            return node.val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
