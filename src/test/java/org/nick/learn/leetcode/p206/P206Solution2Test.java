package org.nick.learn.leetcode.p206;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

class P206Solution2Test {
    P206Solution2 solution = new P206Solution2();

    @Test
    void reverseList() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(node);
        node = solution.reverseList(node);
        ListNode.printListNode(node);
    }
}