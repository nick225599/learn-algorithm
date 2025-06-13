package org.nick.learn.leetcode.p61;

import org.nick.learn.algorithm.list.ListNode;

public class P61Solution1 {

    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k == 0) {
            return head;
        }

        int n = 0;
        for (ListNode node = head;; node = node.next) {
            n++;

            if (null == node.next) {

                if (k % n == 0) {
                    return head;
                }

                node.next = head;
                break;
            }
        }

        int cur = 0;
        for (ListNode node = head; null != node; node = node.next) {
            cur++;

            if (cur == n - (k % n)) {
                ListNode result = node.next;
                node.next = null;
                return result;
            }
        }

        return null;
    }
}
