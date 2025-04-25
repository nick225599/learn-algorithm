package org.nick.learn.leetcode.p141;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionBTest {
    SolutionB solution = new SolutionB();

    @Test
    void hasCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        assertFalse(solution.hasCycle(head));

    }
}