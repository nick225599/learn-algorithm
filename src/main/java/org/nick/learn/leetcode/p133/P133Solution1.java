package org.nick.learn.leetcode.p133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P133Solution1 {

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        // 第一次 copy 只将值复制
        Map<Integer, Node> buff = new HashMap<>();
        return cloneGraph(node, buff);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> buff) {
        Node newNode = buff.get(node.val);
        if(newNode != null){
            return newNode;
        }

        newNode = new Node(node.val);
        buff.put(newNode.val, newNode);


        List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());
        for(Node neighbor : node.neighbors){
            Node newNeighbor = this.cloneGraph(neighbor, buff);
            newNeighbors.add(newNeighbor);
        }
        newNode.neighbors = newNeighbors;

        return newNode;
    }



}
