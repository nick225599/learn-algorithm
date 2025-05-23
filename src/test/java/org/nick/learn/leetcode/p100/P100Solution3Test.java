package org.nick.learn.leetcode.p100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P100Solution3Test {
    P100Solution3 solution = new P100Solution3();
    @Test
    void isSameTree() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(p, q));
    }

    @Test
    void isSameTree1() {
        TreeNode p = new TreeNode(1, null, null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(p, q));
    }


    @Test
    void isSameTree2() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p, q));
    }


}