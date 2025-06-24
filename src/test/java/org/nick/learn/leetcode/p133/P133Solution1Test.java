package org.nick.learn.leetcode.p133;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P133Solution1Test {
    P133Solution1 solution = new P133Solution1();

    @Test
    void cloneGraph() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        List<Node> neighbors1 = new ArrayList<>();
        List<Node> neighbors2 = new ArrayList<>();
        neighbors1.add(n2);
        neighbors2.add(n1);
        n1.neighbors = neighbors1;
        n2.neighbors = neighbors2;

        Node newNode1 = solution.cloneGraph(n1);

    }
}