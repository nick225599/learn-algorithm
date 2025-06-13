package org.nick.learn.leetcode.p86;

import org.nick.learn.algorithm.list.ListNode;

public class P86Solution1 {

    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next || x == 100 || x == -100) {
            return head;
        }

        ListNode leftHead = new ListNode();
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode();
        ListNode rightTail = rightHead;
        for (ListNode node = head; null != node; node = node.next) {
            int val = node.val;
            if (val < x) {
                leftTail.next = node;
                leftTail = leftTail.next;

            } else {
                rightTail.next = node;
                rightTail = rightTail.next;
            }
        }

        leftTail.next = rightHead.next;
        rightTail.next = null;

        return leftHead.next;

    }

}
