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

public class P148Solution14 {

    // 自己尝试一下 O(1) 空间复杂度的解法
    //TODO nick 超时了，吃过饭查下为啥
    public ListNode sortList(ListNode head) {
        int length = calculateLength(head);

        ListNode dummy = new ListNode();
        dummy.next = head;

        for (int granularity = 1; granularity <= length; granularity <<= 1) {

            ListNode pre = dummy;
            ListNode cur = pre.next;


            while (cur != null) {

                // 拆解出前面的部分、第 1 份、第 2 份以及剩余部分
                ListNode head1, tail1;
                head1 = cur;
                tail1 = head1;
                for (int i = 1; i < granularity; i++) {
                    if (tail1.next == null) {
                        break;
                    }
                    tail1 = tail1.next;
                }

                if (tail1.next == null) {
                    break;
                }

                ListNode head2, tail2;
                head2 = tail1.next;
                tail2 = head2;
                for (int i = 1; i < granularity; i++) {
                    if (tail2.next == null) {
                        break;
                    }
                    tail2 = tail2.next;
                }

                ListNode next;
                if (tail2.next == null) {
                    next = null;
                } else {
                    next = tail2.next;
                }

                // 两两合并（合并时保持有序）
                ListNode headOfSortedList = this.merge(head1, head2);
                ListNode tailOfSortedList = headOfSortedList;
                while(tailOfSortedList.next != null){
                    tailOfSortedList = tailOfSortedList.next;
                }

                // 将第 1 份和第 2 份的合并结果拼接回去
                pre.next = headOfSortedList;
                tailOfSortedList.next = next;

                // 为后续两份做准备
                pre = tailOfSortedList;
                cur = next;
            }
        }

        return dummy.next;
    }

    private int calculateLength(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        return l;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        node.next = left != null ? left : right;
        return dummy.next;
    }


}
