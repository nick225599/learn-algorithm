package org.nick.learn.leetcode.p146;

import java.util.LinkedHashMap;

public class P146Solution3 {


    static class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int capacity;

        //TODO 看下官方题解咋处理的
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        // O(1) 时间复杂度
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }


        // O(1) 时间复杂度
        public void put(int key, int value) {
            map.put(key, value);
            if (map.size() > capacity){
                map.remove(map.sequencedKeySet().getLast());
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
