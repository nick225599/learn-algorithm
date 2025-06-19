package org.nick.learn.leetcode.p173;

import org.junit.jupiter.api.Test;
import org.nick.learn.leetcode.p100.TreeNode;
import org.nick.learn.leetcode.p173.P173Solution3.BSTIterator;

import static org.junit.jupiter.api.Assertions.*;

class P173Solution3Test {

    @Test
    public void test() {
        TreeNode root = new TreeNode(7, new TreeNode(3, null, null),
                new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        P173Solution3.BSTIterator bSTIterator = new P173Solution3.BSTIterator(root);
//        P173Solution4.BSTIterator bSTIterator = new P173Solution4.BSTIterator(root);
        assertEquals(3, bSTIterator.next());    // 返回 3
        assertEquals(7, bSTIterator.next());    // 返回 7
        assertTrue(bSTIterator.hasNext()); // 返回 True
        assertEquals(9, bSTIterator.next());    // 返回 9
        assertTrue(bSTIterator.hasNext()); // 返回 True
        assertEquals(15, bSTIterator.next());   // 返回 15
        assertTrue(bSTIterator.hasNext()); // 返回 True
        assertEquals(20, bSTIterator.next());    // 返回 20
        assertFalse(bSTIterator.hasNext()); // 返回 False

    }

}