package org.nick.learn.leetcode.p138;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.nick.learn.leetcode.p138.Node.printNode;

class P138Solution3Test {
    P138Solution3 solution = new P138Solution3();


    @Test
    void copyRandomList() {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random= n2;
        n4.random = n0;

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printNode(n0);
        Node newN0 = solution.copyRandomList(n0);
        printNode(newN0);
        System.out.println(n0.equals(newN0));
    }

}