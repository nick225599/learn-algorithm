package org.nick.learn.leetcode.p129;

import org.nick.learn.leetcode.p100.TreeNode;

public class P129Solution2 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int i) {
        if(node  == null){
            return 0;
        }
        i = node.val + i * 10;
        if(node.left == null && node.right == null){
            return i;
        }else{
            return dfs(node.left, i) + dfs(node.right, i);
        }
    }


}
