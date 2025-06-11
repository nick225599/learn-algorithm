package org.nick.learn.leetcode.p206;

import org.nick.learn.algorithm.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P206Solution1 {

    // 没思路
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list = list.reversed();
        ListNode newHead = new ListNode(list.getFirst());
        ListNode node = newHead;
        for (int i = 1; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return newHead;
    }
}
