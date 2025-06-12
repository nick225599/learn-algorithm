package org.nick.learn.leetcode.p19;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

class P19Solution1Test {
    P19Solution1 solution = new P19Solution1();

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