package org.nick.learn.leetcode.p641;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularDeque0Test {
    @Test
    public void test() {
        MyCircularDeque0 circularDeque = new MyCircularDeque0(3);    // 设置容量大小为3
        assertTrue(circularDeque.insertLast(1));                    // 返回 true
        assertTrue(circularDeque.insertLast(2));                    // 返回 true
        assertTrue(circularDeque.insertFront(3));                   // 返回 true
        assertFalse(circularDeque.insertFront(4));                  // 已经满了，返回 false
        assertEquals(2, circularDeque.getRear());                // 返回 2
        assertTrue(circularDeque.isFull());                               // 返回 true
        assertTrue(circularDeque.deleteLast());                           // 返回 true
        assertTrue(circularDeque.insertFront(4));                   // 返回 true
        assertEquals(4, circularDeque.getFront());               // 返回 4



        circularDeque = new MyCircularDeque0(3);    // 设置容量大小为3
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