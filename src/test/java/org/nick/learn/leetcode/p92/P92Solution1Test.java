package org.nick.learn.leetcode.p92;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

class P92Solution1Test {

    P92Solution1 solution = new P92Solution1();

    @Test
    void reverseBetween() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead = solution.reverseBetween(head, 2, 4);
        this.printListNode(reversedHead);
    }

    @Test
    void reverseBetween2() {
        ListNode head = new ListNode(3, new ListNode(5));
        ListNode reversedHead = solution.reverseBetween(head, 1, 2);
        this.printListNode(reversedHead);
    }

    private void printListNode(ListNode reversedHead) {
        StringBuilder sb = new StringBuilder("[");
        ListNode node = reversedHead;
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb);
    }


}