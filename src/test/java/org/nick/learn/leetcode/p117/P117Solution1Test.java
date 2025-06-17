package org.nick.learn.leetcode.p117;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P117Solution1Test {
    P117Solution1 solution = new P117Solution1();

    @Test
    void connect() {
        Node n = solution.connect(new Node(1,
                new Node(2, new Node(4), new Node(5)),
                new Node(3, null, new Node(7))
        ));
        System.out.println();
    }
}