package org.nick.learn.leetcode.p102;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P102Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> top = new ArrayList<>();
        top.add(root);

        this.bfs(result, top);
        return result;
    }

    private void bfs(List<List<Integer>> result, List<TreeNode> nodes ) {
        if(nodes.isEmpty()){
            return;
        }

        List<TreeNode> nextNodes = new ArrayList<>();

        List<Integer> values = new ArrayList<>();
        for(TreeNode node : nodes){
            values.add(node.val);
            if(node.left != null){
                nextNodes.add(node.left);
            }
            if(node.right != null){
                nextNodes.add(node.right);
            }
        }
        result.add(values);

        bfs(result, nextNodes);
    }
}
