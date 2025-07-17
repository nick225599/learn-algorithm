package org.nick.learn.leetcode.p148;

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
public class P148Solution10 {

    // 时间复杂度 O(n^2)
    // 空间复杂度 O(logn)
    // AI 了一下，可以用快慢指针，找到链表的中间节点
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        left.next = null;
        left = sortList(left);
        right = sortList(right);
        ListNode cur = this.merge(left, right);
        return cur;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        while (left != null) {
            head.next = left;
            head = head.next;
            left = left.next;
        }
        while (right != null) {
            head.next = right;
            head = head.next;
            right = right.next;
        }
        return dummy.next;
    }
}
