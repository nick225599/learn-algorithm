package org.nick.learn.leetcode.p138;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void printNode(Node n){
        StringBuilder sb = new StringBuilder();
        while(null != n){
            sb.append(n.val).append(", ");
            n = n.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}