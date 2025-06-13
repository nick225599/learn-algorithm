package org.nick.learn.leetcode.p82;

import org.nick.learn.algorithm.list.ListNode;

public class P82Solution2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        for (ListNode cur = dummy; null != cur.next && null != cur.next.next; ) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
                continue;
            }
            // 0 1 2 3
            //   ^ ^
            int val = cur.next.val;
            while(null != cur.next && cur.next.val == val){
                cur.next = cur.next.next;
            }
        }
        return dummy.next;
    }
}
