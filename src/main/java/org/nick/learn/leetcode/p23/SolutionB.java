package org.nick.learn.leetcode.p23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

import java.util.PriorityQueue;

/**
 * 如果使用 JDK 自带的优先级队列呢？
 */
@Slf4j
public class SolutionB {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue
                = new PriorityQueue<>((o1, o2) -> {
            if (null == o1) {
                return 1;
            }
            if (null == o2) {
                return -1;
            } else {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (null != list) {
                priorityQueue.offer(list);
            }
        }
        ListNode head, tail;
        head = tail = new ListNode(-1);
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            if (null != node.next) {
                priorityQueue.offer(node.next);
            }
            tail = tail.next;
        }
        return head.next;
    }
}
