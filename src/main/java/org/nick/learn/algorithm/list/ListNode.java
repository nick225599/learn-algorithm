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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[");
//        ListNode node = this;
//        while (node != null) {
//            sb.append(node.val).append(", ");
//            node = node.next;
//        }
//        sb.delete(sb.length() - 2, sb.length());
//        sb.append("]");
//        return sb.toString();
//    }
}
