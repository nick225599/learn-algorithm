package org.nick.learn.leetcode.p105;

import org.nick.learn.leetcode.p100.TreeNode;

public class P105Solution1 {

    // pre-order val, left, right
    // in-order left, val, right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return this.buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j,
                               int[] inorder, int x, int y) {
        int n = j - i + 1;

        if(n <= 0){
            return null;
        }
        if(n == 1){
            return new TreeNode(preorder[i]);
        }

        int leftLength = 0;
        while (preorder[i] != inorder[x + leftLength]) {
            leftLength++;
        }
        int rightLength = n - 1 - leftLength;

        TreeNode cur = new TreeNode(preorder[i]);

        int leftI = i + 1;
        int leftJ = i + leftLength;
        int leftX = x;
        int leftY = x + leftLength - 1;
        cur.left = this.buildTree(preorder, leftI, leftJ, inorder, leftX, leftY);

        int rightI = j - rightLength + 1;
        int rightJ = j;
        int rightX = y - rightLength + 1;
        int rightY = y;
        cur.right = this.buildTree(preorder, rightI, rightJ, inorder, rightX, rightY);

        return cur;
    }


}
