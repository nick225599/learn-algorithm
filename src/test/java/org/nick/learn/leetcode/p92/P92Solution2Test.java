package org.nick.learn.leetcode.p92;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

class P92Solution2Test {

    P92Solution2 solution = new P92Solution2();

    @Test
    void reverseBetween() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead = solution.reverseBetween(head, 2, 4);
        ListNode.printListNode(reversedHead);
    }

    @Test
    void reverseBetween2() {
        ListNode head = new ListNode(3, new ListNode(5));
        ListNode reversedHead = solution.reverseBetween(head, 1, 2);
        ListNode.printListNode(reversedHead);
    }

}