package org.nick.learn.leetcode.p21;

import org.nick.learn.algorithm.list.ListNode;

/**
 * 怎么不新建 ListNode ？ 直接套用 list1 list2
 */
public class SolutionB {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result;
        ListNode tail;
        result = tail = new ListNode(-1);
        list1 = new ListNode(-1, list1);
        list2 = new ListNode(-1, list2);
        while (null != list1.next || null != list2.next) {
            if (null == list1.next) {
                tail.next = list2.next;
                list2 = list2.next;
            } else if (null == list2.next) {
                tail.next = list1.next;
                list1 = list1.next;
            } else if (list1.next.val < list2.next.val) {
                tail.next = list1.next;
                list1.next = list1.next.next;
            } else {
                tail.next = list2.next;
                list2.next = list2.next.next;
            }
            tail = tail.next;
        }
        return result.next;
    }
}
