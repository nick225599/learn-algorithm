package org.nick.learn.leetcode.p114;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.p100.TreeNode;

class P114Solution3Test {
    P114Solution3 solution = new P114Solution3();


    @Test
    void flatten() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));

        solution.flatten(root);



    }
}