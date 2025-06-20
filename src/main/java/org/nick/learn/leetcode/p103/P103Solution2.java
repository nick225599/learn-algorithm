package org.nick.learn.leetcode.p103;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P103Solution2 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        this.dfs(result, root, 0);
        for(int i = 0; i < result.size(); i++){
            if(i  % 2 == 1){
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> result,TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if(level > result.size() - 1){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        dfs(result, node.left, level + 1);
        dfs(result, node.right, level + 1);
    }
}
