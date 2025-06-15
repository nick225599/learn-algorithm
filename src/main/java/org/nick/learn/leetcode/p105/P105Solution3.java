package org.nick.learn.leetcode.p105;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P105Solution3 {

    public static void main(String[] args) {
        new P105Solution3().buildTree(
                new int[]{3, 9, 8, 5, 4, 10, 20, 15, 7},
                new int[]{4, 5, 8, 10, 9, 3, 15, 20, 7});
    }


    // 自己一开始直觉需要用栈的解法是可行的

    // pre-order:  cur, left, right;
    // in-order : left, cur, right;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 这个迭代看了挺久的
        // 核心应该是按照前序遍历来构建二叉树
        // 中序遍历应该是用来定位根节点的

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



}
