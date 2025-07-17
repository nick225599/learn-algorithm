package org.nick.learn.leetcode.p148;

import org.junit.jupiter.api.Test;

class P148Solution14Test {
    P148Solution14 solution = new P148Solution14();

    @Test
    void sortList() {
        // 2, 1, 3
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(3)));
        ListNode node = solution.sortList(head);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb);
    }

    @Test
    void sortList2() {
        // 4, 2, 1, 3
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode node = solution.sortList(head);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb);
    }

    @Test
    void sortList3() {
        // 2, 1
        ListNode head = new ListNode(2, new ListNode(1));
        ListNode node = solution.sortList(head);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb);
    }
}