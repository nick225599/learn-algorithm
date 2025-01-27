package org.nick.learn.leetcode.problem21;

import org.nick.learn.algorithm.list.ListNode;

/**
 * 官方题解，把空判断放在循环外
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
public class SolutionC {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, tail;
        head = tail = new ListNode(-1);
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (null == l1) ? l2 : l1;
        return head.next;
    }
}
