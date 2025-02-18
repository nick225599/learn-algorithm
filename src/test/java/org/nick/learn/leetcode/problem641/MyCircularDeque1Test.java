package org.nick.learn.leetcode.problem641;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularDeque1Test {

    MyCircularDeque1 circularDeque;

    @Test
    public void test() {
        circularDeque = new MyCircularDeque1(3);    // 设置容量大小为3
        assertTrue(circularDeque.insertLast(1));                    // 返回 true
        assertTrue(circularDeque.insertLast(2));                    // 返回 true
        assertTrue(circularDeque.insertFront(3));                   // 返回 true
        assertFalse(circularDeque.insertFront(4));                  // 已经满了，返回 false
        assertEquals(2, circularDeque.getRear());                // 返回 2
        assertTrue(circularDeque.isFull());                               // 返回 true
        assertTrue(circularDeque.deleteLast());                           // 返回 true
        assertTrue(circularDeque.insertFront(4));                   // 返回 true
        assertEquals(4, circularDeque.getFront());               // 返回 4



        circularDeque = new MyCircularDeque1(3);    // 设置容量大小为3
        assertTrue(circularDeque.insertLast(1));                    // 返回 true
        assertTrue(circularDeque.insertLast(2));                    // 返回 true
        assertEquals(1,circularDeque.getFront());
        assertEquals(2, circularDeque.getRear());
        assertFalse(circularDeque.isFull());
        assertTrue(circularDeque.deleteLast());;
        assertTrue(circularDeque.insertFront(4));;
        assertEquals(4, circularDeque.getFront());
    }
}