package org.nick.learn.leetcode.p92;

import org.nick.learn.algorithm.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class P92Solution1 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        Deque<ListNode> stack = new LinkedList<>();
        int i = 1;
        ListNode preNode = null;
        for (ListNode node = head; null != node; node = node.next) {
            if (i < left) {
                preNode = node;
            } else if (i <= right) {
                stack.push(node);
                if (i == right) {
                    ListNode next = node.next;
                    if (null == preNode) {
                        preNode = stack.pop();
                        head = preNode;
                    }
                    while (!stack.isEmpty()) {
                        ListNode tmpNode = stack.pop();
                        preNode.next = tmpNode;
                        preNode = preNode.next;
                    }
                    preNode.next = next;
                }
            } else {
                break;
            }

            i++;
        }
        return head;
    }
}
