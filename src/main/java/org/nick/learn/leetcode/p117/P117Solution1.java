package org.nick.learn.leetcode.p117;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P117Solution1 {

    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public Node connect(Node root) {

        if(null == root){
            return null;
        }

        Queue<Node> stack1 = new LinkedList<>();
        stack1.add(root);

        Queue<Node> stack2 = new LinkedList<>();
        Node pre, cur;


        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            pre = null;
            while (!stack1.isEmpty()) {
                cur = stack1.remove();
                cur.next = pre;
                pre = cur;
                if (null != cur.right) {
                    stack2.add(cur.right);
                }
                if (null != cur.left) {
                    stack2.add(cur.left);
                }
            }

            pre = null;
            while (!stack2.isEmpty()) {
                cur = stack2.remove();
                cur.next = pre;
                pre = cur;
                if (null != cur.right) {
                    stack1.add(cur.right);
                }
                if (null != cur.left) {
                    stack1.add(cur.left);
                }
            }
        }

        return root;
    }

}
