package org.nick.learn.leetcode.p146;

import java.util.HashMap;
import java.util.Map;

public class P146Solution1 {


    static class LRUCache {

        static class DequeNode {
            Integer key;
            Integer value;

            public DequeNode pre;
            public DequeNode next;

            public DequeNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }


        Map<Integer, DequeNode> map;
        int capacity;
        int size = 0;

        // 双向链表
        DequeNode head = null;
        DequeNode tail = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        // O(1) 时间复杂度
        public int get(int key) {
            // 从 map 中查出含有数据的节点
            DequeNode node = map.get(key);
            if (null == node) {
                return -1;
            }

            // 将含有数据的节点从链表中间提到链表头部
            this.putToHead(node);

            return node.value;
        }

        // O(1) 时间复杂度
        public void put(int key, int value) {
            if (size == capacity) {
                this.deleteTail();
            }


            DequeNode dequeNode = map.get(key);
            if (null == dequeNode) {
                dequeNode = new DequeNode(key, value);
                map.put(key, dequeNode);
                size++;
            }

            this.putToHead(dequeNode);
        }

        private void deleteTail() {
            map.remove(tail.key);
            tail.pre.next = null;
            size--;
        }

        private void putToHead(DequeNode node) {
            if (null != node.pre) {
                node.pre.next = node.next;
            }
            if(null == head){
                head = tail = node;
                return;
            }
            node.next = head;
            head.pre = node;
            head = node;
            if(null == tail){
                tail = head;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
