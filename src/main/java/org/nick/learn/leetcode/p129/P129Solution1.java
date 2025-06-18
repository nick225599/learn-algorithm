package org.nick.learn.leetcode.p129;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P129Solution1 {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int i) {
        if(node  == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return node.val + i * 10;
        }

        int sum = 0;
        i = i * 10 + node.val;
        sum += sumNumbers(node.left, i);
        sum += sumNumbers(node.right, i);
        return sum;
    }


}
