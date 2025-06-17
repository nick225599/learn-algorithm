package org.nick.learn.leetcode.p117;

public class P117Solution3 {

    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node prev = dummy;

            while (head != null) {
                Node left = head.left;
                if (left != null) {
                    prev.next = left;
                    prev = left;
                }

                Node right = head.right;
                if (right != null) {
                    prev.next = right;
                    prev = right;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }


}
