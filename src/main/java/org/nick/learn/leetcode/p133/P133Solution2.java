package org.nick.learn.leetcode.p133;


import java.util.*;

public class P133Solution2 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Integer, Node> buff = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            Node newNode = buff.get(n.val);
            if (newNode == null) {
                newNode = new Node(n.val);
                buff.put(newNode.val, newNode);
                queue.addAll(n.neighbors);
            }
        }

        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            Node newNode = buff.get(n.val);
            if (!n.neighbors.isEmpty() && newNode.neighbors.isEmpty()) {
                for(Node neighbor: n.neighbors){
                    newNode.neighbors.add(buff.get(neighbor.val));
                }
                queue.addAll(n.neighbors);
            }
        }

        return buff.get(node.val);
    }


}
