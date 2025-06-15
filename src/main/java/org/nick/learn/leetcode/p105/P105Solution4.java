package org.nick.learn.leetcode.p105;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P105Solution4 {

    public static void main(String[] args) {
        new P105Solution4().buildTree(
                new int[]{3, 9, 8, 5, 4, 10, 20, 15, 7},
                new int[]{4, 5, 8, 10, 9, 3, 15, 20, 7});
    }


    // 自己一开始直觉需要用栈的解法是可行的

    // pre-order: 父父节点, 父节点, [ 根节点,               [左子树的前序遍历结果], [右子树的前序遍历结果] ], [父节点的右子树的前序遍历结果], [父父节点的右子树的前序遍历结果]
    // in-order :  [ [左子树的中序遍历结果], 根节点,               [右子树的中序遍历结果] ], 父节点, [父节点的右子树的中序遍历结果]
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(new TreeNode(preorder[0]));

        int indexOfPreorder = 1;
        int indexOfInorder = 0;

        // 左子树为空？

        //TODO nick 好好看下迭代法是怎么对问题进行迭代模型的建模的
        return null;



    }


}
