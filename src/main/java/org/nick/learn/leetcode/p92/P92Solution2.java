package org.nick.learn.leetcode.p92;

import org.nick.learn.algorithm.list.ListNode;

public class P92Solution2 {

    // 学习官方题解，根本不需要 O(right - left) 的空间复杂度
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0, head);
        ListNode beforeLeftNode;
        ListNode leftNode;
        ListNode rightNode;
        ListNode afterRightNode;

        ListNode tmp = newHead;

        int i = 1;
        for (; i <= left - 1; i++) {
            tmp = tmp.next;
        }
        beforeLeftNode = tmp;

        for (; i <= left; i++) {
            tmp = tmp.next;
        }
        leftNode = tmp;

        for (; i <= right; i++) {
            tmp = tmp.next;
        }
        rightNode = tmp;

        for (; i <= right + 1; i++) {
            tmp = tmp.next;
        }
        afterRightNode = tmp;

        // 截断后翻转
        beforeLeftNode.next = null;
        rightNode.next = null;
        reverse(leftNode);

        // 拼接
        beforeLeftNode.next = rightNode;
        leftNode.next = afterRightNode;

        return newHead.next;
    }

    private void reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
