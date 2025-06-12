package org.nick.learn.leetcode.p92;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

@Slf4j
public class P92Solution4 {

    // 学习官方题解，根本不需要 O(right - left) 的空间复杂度
    // 写不出来 人都傻了
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0; i < right - left; i++){
            next = cur.next;
            cur.next  = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return newHead.next;
    }
}
