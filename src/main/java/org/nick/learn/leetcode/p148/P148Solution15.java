package org.nick.learn.leetcode.p148;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class P148Solution15 {

    // 民间 2ms 法
    // 计数排序，虽然计数排序不通用，但是这个场景好用，
    // -10^5 <= Node.val <= 10^5
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (cur != null) {
            max = Math.max(max, cur.val);
            min = Math.min(min, cur.val);
            cur = cur.next;
        }
        // 根据题意，records 最大为 new int[20_0000]
        int[] records = new int[max - min + 1];
        cur = head;
        while (cur != null) {
            records[cur.val - min]++;
            cur = cur.next;
        }
        cur = head;
        int i = 0;
        while (cur != null) {
            if (records[i] != 0) {
                cur.val = i + min;
                records[i]--;
                cur = cur.next;
            } else {
                i++;
            }
        }
        return head;


    }

}
