package org.nick.learn.algorithm.list;

import lombok.Getter;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("" + val);
        ListNode tail = this;
        while((tail = tail.next) != null){
            sb.append(",").append(tail.val);
        }
        return sb.toString();
    }
}
