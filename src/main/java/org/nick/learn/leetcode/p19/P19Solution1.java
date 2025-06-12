package org.nick.learn.leetcode.p19;

import org.nick.learn.algorithm.list.ListNode;

public class P19Solution1 {

    // 进阶：你能尝试使用一趟扫描实现吗？
    // 咋做到一次扫描就实现？
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preN = new ListNode(0, head);
        ListNode tmp = preN;
        ListNode cur;
        int i;
        for (i = 0, cur = head; null != cur; cur = cur.next, i++) {
            if (i >= n) {
                preN = preN.next;
            }
            if (null == cur.next) {
                if (null != preN.next) {
                    preN.next = preN.next.next;
                }
            }
        }
        return tmp.next;
    }
}
