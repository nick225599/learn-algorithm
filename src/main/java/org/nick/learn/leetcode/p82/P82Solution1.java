package org.nick.learn.leetcode.p82;

import org.nick.learn.algorithm.list.ListNode;

public class P82Solution1 {

    // head =
    //[1,2,3,3,4,4,5]
    //输出
    //[1,2,3,4,5]
    //预期结果
    //[1,2,5]
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (null != pre && null != cur && pre.val == cur.val) {
            pre = cur.next;
            if (null != pre) {
                cur = pre.next;
            } else {
                cur = null;
            }
        }

        if (null == cur) {
            return head;
        }

        while (null != cur) {
            ListNode succ = cur.next;
            while (null != succ) {
                if (cur.val == succ.val) {
                    succ = succ.next;
                } else {
                    pre = cur;
                    cur = succ;
                    succ = succ.next;
                }
            }
            pre.next = succ;

            pre = succ;
            if (null != pre) {
                cur = pre.next;
            } else {
                cur = null;
            }
        }

        return head;
    }
}
