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
public class P148Solution11 {

    // 快慢指针找到中间节点
    // 时间复杂度 O(nlogn)
    // 空间复杂度 O(logn)
    // 11ms 击败63%
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            if (head.val > head.next.val) {
                ListNode n = head.next;
                n.next = head;
                head.next = null;
                return n;
            } else {
                return head;
            }
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        return this.merge(left, right);
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
