package org.nick.learn.leetcode.p199;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P199Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        this.dfs(root, list, 0);
        return list;
    }

    /**
     * @param i list 待写入的下标
     */
    private void dfs(TreeNode node, List<Integer> list, int i) {
        if(node == null){
            return;
        }
        if (i > list.size() - 1) {
            list.add(node.val);
        }
        i++;
        dfs(node.right, list, i);
        dfs(node.left, list, i);
    }
}
