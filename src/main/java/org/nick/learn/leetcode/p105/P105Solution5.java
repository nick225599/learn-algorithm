package org.nick.learn.leetcode.p105;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class P105Solution5 {

    public static void main(String[] args) {
        new P105Solution5().buildTree(
                new int[]{3, 9, 8, 5, 4, 10, 20, 15, 7},
                new int[]{4, 5, 8, 10, 9, 3, 15, 20, 7});
    }


    // 自己一开始直觉需要用栈的解法是可行的

    // pre-order: val, [left.val, left.left, left.right], [R.val, R.left, R.right][parent.val, parent.left, parent.right][p.p.val, p.p.left, p.p.right]
    // in-order: [left.left, left.val, left.right], val, [R.left, R.val, R.right]

    // pre-order: val, [L.val, L.left, L.right], [R.val, R.left, R.right][parent.val, parent.left, parent.right][p.p.val, p.p.left, p.p.right]
    // in-order: [L.left, L.val, L.right], val, [R.left, R.val, R.right], parent.val, [parent.R.left, parent.R.val, parent.R.right ]

    // 自己参照着官方题解努力写出来的
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        // 只处理没有评估过有右节点的元素
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            // node 是不是上一个节点的右子树？
            // 如果是右子树的元素，那么 inorder[inorderIndex] == stack.peek().val
            if (inorder[inorderIndex] == stack.peek().val) {
                TreeNode parent = null;

                // 如果栈元素跟前序序列元素顺序一样，说明栈顶元素没有右节点，
                // 那么找到那个不一样的元素，那么这个不一样的元素就是前序序列的前一个元素的右节点
                while (!stack.isEmpty() && inorder[inorderIndex] == stack.peek().val) {
                    parent = stack.pop();
                    inorderIndex++;
                }
                parent.right = node;
            } else {
                stack.peek().left = node;
            }

            stack.push(node);
        }


        return root;
    }


}
