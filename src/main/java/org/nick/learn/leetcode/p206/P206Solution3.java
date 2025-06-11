package org.nick.learn.leetcode.p206;

import org.nick.learn.algorithm.list.ListNode;

public class P206Solution3 {

    // 迭代，精简版本
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
