package org.nick.learn.algorithm.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toStr() {
        StringBuilder sb = new StringBuilder("" + val);
        ListNode tail = this;
        while((tail = tail.next) != null){
            sb.append(",").append(tail.val);
        }
        return sb.toString();
    }
}
