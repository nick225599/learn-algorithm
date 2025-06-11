package org.nick.learn.leetcode.p206;

import org.nick.learn.algorithm.list.ListNode;

public class P206Solution2 {

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode node = head;
        while (null != node) {
            ListNode next = node.next;

            if (null == ans) {
                ans = node;
                ans.next = null;
            } else {
                node.next = ans;
                ans = node;
            }

            node = next;
        }
        return ans;
    }


}
