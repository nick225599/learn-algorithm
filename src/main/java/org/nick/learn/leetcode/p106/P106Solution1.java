package org.nick.learn.leetcode.p106;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P106Solution1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, inorder, postorder, 0, n - 1, 0, n - 1);
    }

    // in-order: L, val, R
    // post-order: L, R, val
    private TreeNode buildTree(Map<Integer, Integer> map, int[] inorder, int[] postorder, int i, int j, int x, int y) {
        if (x > y) {
            return null;
        }

        if (x == y) {
            return new TreeNode(postorder[y]);
        }

        int val = postorder[y];
        int inorderIndexOfVal = map.get(val);
        int leftLength = (inorderIndexOfVal - 1) - i + 1;
        int rightLength = j - (inorderIndexOfVal + 1) + 1;

        TreeNode cur = new TreeNode(val);
        cur.left = buildTree(map, inorder, postorder,
                i, i + leftLength - 1,
                x, x + leftLength - 1);
        cur.right = buildTree(map, inorder, postorder,
                i + leftLength + 1, i + leftLength + rightLength,
                x + leftLength, x + leftLength + rightLength - 1);
        return cur;
    }
}
