package org.nick.learn.leetcode.p133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P133Solution1 {

    public Node cloneGraph(Node node) {

        // 第一次 copy 只将值复制
        Map<Integer, Node> buff = new HashMap<>();
        this.copy1(node, buff);

//        // 第二次 copy 将引用复制
//        Map<Integer, Node> buff2 = new HashMap<>();
//        this.copy2(node, buff, buff2);
//
//        return buff2.get(node.val);
        return null;
    }

    private void copy1(Node node, Map<Integer, Node> buff) {
        Node newNode = buff.get(node.val);
        if(newNode == null){
            newNode = new Node(node.val);
            buff.put(node.val, newNode);
        }
        buff.computeIfAbsent(node.val, k->new Node(node.val));
        for(Node n: node.neighbors){
            this.copy1(n, buff);
        }
    }

//    private void copy2(Node node, Map<Integer, Node> shallowCpoyMap, Map<Integer, Node> deepCopyMap) {
//        Node newNode = buff.get(node.val);
//        List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());
//        for(Node neighbor : node.neighbors){
//            newNeighbors.add(buff.get(neighbor.val));
//        }
//        newNode.neighbors = newNeighbors;
//
//        buff.put(node.val, newNode);
//        return newNode;
//    }

}
