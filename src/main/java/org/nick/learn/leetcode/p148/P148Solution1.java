package org.nick.learn.leetcode.p148;

public class P148Solution1 {

    private ListNode head;
    private ListNode tail;


    // n^2 复杂度的排序 也得能写出来吧
    public ListNode sortList(ListNode n) {
        this.head = n;
        this.tail = n;
        ListNode next = tail.next;
        while (next != null) {
            this.sort(head, tail, next);
            next = tail.next;
        }
        return head;
    }

    private void sort(ListNode head, ListNode tail, ListNode next) {
        ListNode n = head;
        while(n != null){
            if(n.val < next.val){
                n = n.next;
            }
        }
    }


}
