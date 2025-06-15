package org.nick.learn.leetcode.p146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P146Solution2Test {
    P146Solution2 solution = new P146Solution2();

    @Test
    public void test() {
        P146Solution2.LRUCache cache = new P146Solution2.LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2); // 2, 1

        assertEquals(1, cache.get(1)); // 1, 2
        cache.put(3, 3); // 3, 1
        assertEquals(-1, cache.get(2));
        cache.put(4, 4); // 4, 3
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}