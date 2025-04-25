package org.nick.learn.leetcode.p21;

import org.nick.learn.algorithm.list.ListNode;

/**
 * 时间复杂度 O(n)
 * 空间复杂度应该是 O(n) ，力扣检测出来是 O(1) 肯定是不对的
 */
public class SolutionA {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result;
        ListNode tail;
        result = tail = new ListNode();
        list1 = new ListNode(-1, list1);
        list2 = new ListNode(-1, list2);
        while (null != list1.next || null != list2.next) {
            if (null == list1.next) {
                tail.next = new ListNode(list2.next.val);
                list2 = list2.next;
            } else if (null == list2.next) {
                tail.next = new ListNode(list1.next.val);
                list1 = list1.next;
            } else if (list1.next.val < list2.next.val) {
                tail.next = new ListNode(list1.next.val);
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.next.val);
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return result.next;
    }
}
