package org.nick.learn.leetcode.p19;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class P19Solution2Test {
    P19Solution2 solution = new P19Solution2();

    @Test
    void removeNthFromEnd() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        ListNode list2 = solution.removeNthFromEnd(list1, 2);
        ListNode.printListNode(list2);
    }

    @Test
    void removeNthFromEnd2() {
        ListNode list1 = new ListNode(5);
        ListNode.printListNode(list1);
        ListNode list2 = solution.removeNthFromEnd(list1, 1);
        ListNode.printListNode(list2);
    }
}