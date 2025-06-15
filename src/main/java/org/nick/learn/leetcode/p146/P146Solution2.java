package org.nick.learn.leetcode.p146;

import java.util.HashMap;
import java.util.Map;

public class P146Solution2 {


    static class LRUCache {

        static class DequeNode {
            Integer key;
            Integer value;

            public DequeNode pre;
            public DequeNode next;

            public DequeNode(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }


        Map<Integer, DequeNode> map;
        int capacity;
        int size = 0;

        // 双向链表
        DequeNode head = new DequeNode(null, null);
        DequeNode tail = new DequeNode(null, null);

        {
            head.next = tail;
            tail.pre = head;
        }

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

            // 放置到队首
            this.putToHead(node);

            return node.value;
        }

        private void putToHead(DequeNode node) {
            // 修改 node 前元素的后指针
            // 修改 node 后元素的前指针
            if(null != node.pre && null != node.next) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            // 修改自己的后指针
            node.next = head.next;
            // 修改 队首 的前指针
            head.next.pre = node;

            // 修改自己的前指针
            node.pre = head;
            // 修改 head 的后指针
            head.next = node;
        }

        // O(1) 时间复杂度
        public void put(int key, int value) {

            // 如果已有，则更新元素，并放置到队首
            DequeNode node = map.get(key);
            if(null != node){
                // 更新元素
                node.value = value;

                // 放置到队首
                this.putToHead(node);

                return;
            }

            // 如果未有，则插入新元素，并置顶
            node = new DequeNode(key, value);

            // 插入元素
            map.put(key, node);
            size++;

            // 置顶
            this.putToHead(node);

            // 如果超员，则删除队尾
            if(size > capacity){
                map.remove(tail.pre.key);
                size--;

                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
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
