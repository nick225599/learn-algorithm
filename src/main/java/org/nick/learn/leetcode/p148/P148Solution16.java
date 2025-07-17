package org.nick.learn.leetcode.p148;

import java.util.Arrays;

public class P148Solution16 {
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

    // 转数组后排序，再转链表，很难评
    // 在小规模的数据场景下，用简单的实现换取开发效率
    public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // The number of nodes in the list is in the range [0, 5 * 10^4].
        // 根据题意最大长度为 new int[50000]
        int[] a = new int[count];

        cur = head;
        int i = 0;
        while (cur != null) {
            a[i] = cur.val;
            i++;
            cur = cur.next;
        }
        Arrays.sort(a);
        cur = head;
        i = 0;
        while (cur != null) {
            cur.val = a[i];
            i++;
            cur = cur.next;
        }
        return head;
    }
}
