package org.nick.learn.leetcode.p2;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class P2Solution1Test {
    P2Solution1 solution = new P2Solution1();

    @Test
    void addTwoNumbers() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode sum = solution.addTwoNumbers(l1, l2);
        System.out.println(sum.toStr());
    }

    @Test
    void addTwoNumbers2() {
        // 99 + 9 = 108
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(9);
        ListNode sum = solution.addTwoNumbers(l1, l2);
        System.out.println(sum.toStr());
    }
}