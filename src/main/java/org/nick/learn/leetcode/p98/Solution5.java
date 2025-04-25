package org.nick.learn.leetcode.p98;

import org.nick.learn.leetcode.p226.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {

    // 中序遍历，不用递归
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>(); // 未访问过的节点
        double inorder = -Double.MAX_VALUE; // 前一个被遍历到的节点值

        while (!stack.isEmpty() || root != null) {

            // 不断压入左子节点，压完则栈顶就是最小值
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 取出栈顶值，与前一个值继续比较，当前值应该永远 > 前一个值
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;

            // 继续处理当前节点的右子节点
            root = root.right;
        }
        return true;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//        if (null == root) return true;
//        Queue<TreeNode> deque = new LinkedList<>();
//        putBSTIntoQueue(root, deque);
//        TreeNode node = deque.poll();
//        int preVal = node.val;
//        while ((node = deque.poll()) != null) {
//            if (preVal >= node.val) {
//                return false;
//            }
//            preVal = node.val;
//        }
//        return true;
    }

    private void putBSTIntoQueue(TreeNode node, Queue<TreeNode> deque) {
        if (null == node) return;
        putBSTIntoQueue(node.left, deque);
        deque.add(node);
        putBSTIntoQueue(node.right, deque);
    }



}
