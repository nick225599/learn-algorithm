package org.nick.learn.leetcode.problem112;

import org.nick.learn.leetcode.problem226.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    // 广度优先
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public boolean hasPathSum(TreeNode treeNode, int targetSum) {
        if (null == treeNode) {
            return false;
        }

        Deque<TreeNode> nodesDeque = new LinkedList<>();
        Deque<Integer> valuesDeque = new LinkedList<>();
        nodesDeque.push(treeNode);
        valuesDeque.push(treeNode.val);

        while (!nodesDeque.isEmpty()){
            TreeNode node = nodesDeque.pop();
            Integer nodeVal = valuesDeque.pop();
            if(null == node.left && null == node.right
                    && nodeVal == targetSum){
                return true;
            }
            if(null != node.left){
                nodesDeque.push(node.left);
                valuesDeque.push(node.left.val + nodeVal);
            }
            if(null != node.right){
                nodesDeque.push(node.right);
                valuesDeque.push(node.right.val + nodeVal);
            }
        }
        return false;
    }
}
