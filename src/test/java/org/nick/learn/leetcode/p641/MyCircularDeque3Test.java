package org.nick.learn.leetcode.p641;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularDeque3Test {

    MyCircularDeque3 deque;

    @Test
    public void test1() {
        deque = new MyCircularDeque3(3);    // 设置容量大小为3
        assertTrue(deque.insertLast(1));                    // 返回 true
        assertTrue(deque.insertLast(2));                    // 返回 true
        assertTrue(deque.insertFront(3));                   // 返回 true
        assertFalse(deque.insertFront(4));                  // 已经满了，返回 false
        assertEquals(2, deque.getRear());                // 返回 2
        assertTrue(deque.isFull());                               // 返回 true
        assertTrue(deque.deleteLast());                           // 返回 true
        assertTrue(deque.insertFront(4));                   // 返回 true
        assertEquals(4, deque.getFront());               // 返回 4
    }

    @Test
    public void test2() {
        deque = new MyCircularDeque3(3);    // 设置容量大小为3
        assertTrue(deque.insertLast(1));                    // 返回 true
        assertTrue(deque.insertLast(2));                    // 返回 true
        assertEquals(1, deque.getFront());
        assertEquals(2, deque.getRear());
        assertFalse(deque.isFull());
        assertTrue(deque.deleteLast());;
        assertTrue(deque.insertFront(4));;
        assertEquals(4, deque.getFront());
    }

    @Test
    public void test() {
        deque = new MyCircularDeque3( 4);
        assertTrue(deque.insertFront(9));
        assertTrue(deque.deleteLast());
        assertEquals(-1, deque.getRear()); // -1 ????
        assertEquals(-1, deque.getFront());;
        assertEquals(-1, deque.getFront());;
        assertFalse(deque.deleteFront());
        assertTrue(deque.insertFront(6));
        assertTrue(deque.insertLast(5));
        assertTrue(deque.insertFront(9));
        assertEquals(9, deque.getFront());
        assertTrue(deque.insertFront(6));
    }
}