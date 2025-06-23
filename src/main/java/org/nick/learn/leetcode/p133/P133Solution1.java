package org.nick.learn.leetcode.p133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class P133Solution1 {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> buff1 = new HashMap<>();
        Map<Integer, Node> buff2 = new HashMap<>();

        return cloneGraph(node, buff1, buff2);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> buff1, Map<Integer, Node> buff2) {
        Node newNode = buff2.get(node.val);
        if(newNode != null){
            return newNode;
        }

        newNode = buff1.get(node.val);
        if(newNode == null){
            newNode = new Node(node.val);
            buff1.put(node.val, newNode);
        }

        List<Node> list = new ArrayList<>(node.neighbors.size());
        for (Node n : node.neighbors) {
            list.add(cloneGraph(n, buff1, buff2));
        }
        newNode.neighbors = list;

        buff1.remove(node.val);
        buff2.put(node.val, newNode);

        return newNode;
    }
}
