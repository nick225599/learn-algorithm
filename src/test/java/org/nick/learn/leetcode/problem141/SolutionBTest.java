package org.nick.learn.leetcode.problem141;

import org.junit.jupiter.api.Test;

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