package org.nick.learn.leetcode.p138;

import java.util.HashMap;
import java.util.Map;

public class P138Solution2 {

    // 回溯 + 哈希表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = this.copy(head, map);
        return newHead;
    }

    private Node copy(Node node, Map<Node, Node> map) {
        if (null == node) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.next = this.copy(node.next, map);
        newNode.random = this.copy(node.random, map);
        return newNode;
    }

}
