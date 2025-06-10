package org.nick.learn.leetcode.p138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138Solution1 {

    public Node copyRandomList(Node head) {
        if(null == head){
            return null;
        }

        // head 转 List<Node>
        List<Node> oriNodeList = this.nodeToList(head);

        // 值拷贝
        Node newHead = this.valCopy(head);

        // random 拷贝
        List<Node> newNodeList = this.nodeToList(newHead);
        Map<Node, Integer> map = this.listToMap(oriNodeList);
        for (int i = 0; i < oriNodeList.size(); i++) {
            Node oriNode = oriNodeList.get(i);
            Node newNode = newNodeList.get(i);
            Node oriNodeRandom = oriNode.random;
            if (null == oriNodeRandom) {
                newNode.random = null;
            } else {
                int indexOfNext = map.get(oriNodeRandom);
                newNode.random = newNodeList.get(indexOfNext);
            }
        }

        return newHead;
    }

    private Map<Node, Integer> listToMap(List<Node> list) {
        Map<Node, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        return map;
    }

    private Node valCopy(Node oriHead) {
        Node newHead = new Node(oriHead.val);
        Node newNode = newHead;
        Node oriNode = oriHead;
        while (null != oriNode.next) {
            newNode.next = new Node(oriNode.next.val);
            newNode = newNode.next;
            oriNode = oriNode.next;
        }
        return newHead;
    }

    private List<Node> nodeToList(Node head) {
        List<Node> list = new ArrayList<>();
        Node tmpNode = head;
        while (null != tmpNode) {
            list.add(tmpNode);
            tmpNode = tmpNode.next;
        }
        return list;
    }
}
