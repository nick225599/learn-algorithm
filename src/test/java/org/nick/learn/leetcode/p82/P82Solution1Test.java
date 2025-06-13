package org.nick.learn.leetcode.p82;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

class P82Solution1Test {
    P82Solution1 solution = new P82Solution1();

    @Test
    void deleteDuplicates() {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5)))))));
        ListNode.printListNode(list1);
        ListNode list2 = solution.deleteDuplicates(list1);
        ListNode.printListNode(list2);

    }
}