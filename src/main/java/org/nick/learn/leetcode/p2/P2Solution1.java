package org.nick.learn.leetcode.p2;

import org.nick.learn.algorithm.list.ListNode;

public class P2Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        int carry = 0;
        while(null != l1 || null != l2 || carry == 1){
            int valOfL1 = 0;
            if (null != l1) {
                valOfL1 = l1.val;
                l1 = l1.next;
            }

            int valOfL2 = 0;
            if (null != l2) {
                valOfL2 = l2.val;
                l2 = l2.next;
            }

            int bitSum = valOfL1 + valOfL2 + carry;

            node.next = new ListNode(bitSum % 10);
            node = node.next;

            carry = (bitSum >= 10) ? 1: 0;
        }
        return result.next;
    }
}
