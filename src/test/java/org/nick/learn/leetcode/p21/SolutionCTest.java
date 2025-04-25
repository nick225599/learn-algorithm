package org.nick.learn.leetcode.p21;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionCTest {
    SolutionC solution = new SolutionC();

    @Test
    void mergeTwoLists() {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merged = solution.mergeTwoLists(list1, list2);
        assertEquals("1,1,2,3", merged.toStr());
    }
}