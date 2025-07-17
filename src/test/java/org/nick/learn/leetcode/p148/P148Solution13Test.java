package org.nick.learn.leetcode.p148;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P148Solution13Test {
    P148Solution13 solution = new P148Solution13();

    @Test
    void sortList() {
        // 2, 1, 3
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(3)));
        solution.sortList(head);

    }
}