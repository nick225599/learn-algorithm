package org.nick.learn.leetcode.p295;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P295Solution6Test {

    P295Solution6.MedianFinder mf = new P295Solution6.MedianFinder();

    @Test
    public void test01() {
        mf.addNum(50);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test02() {
        mf.addNum(50);
        mf.addNum(40);
        assertEquals(45, mf.findMedian());
    }

    @Test
    public void test03() {
        mf.addNum(50);
        mf.addNum(50);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test04() {
        mf.addNum(50);
        mf.addNum(60);
        assertEquals(55, mf.findMedian());
    }

    // 偶数情况，且不等
    @Test
    public void test05() {
        mf.addNum(50);
        mf.addNum(60);
        mf.addNum(40);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test06() {
        mf.addNum(50);
        mf.addNum(60);
        mf.addNum(50);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test07() {
        mf.addNum(50);
        mf.addNum(60);
        mf.addNum(55);
        assertEquals(55, mf.findMedian());
    }

    @Test
    public void test08() {
        mf.addNum(50);
        mf.addNum(60);
        mf.addNum(60);
        assertEquals(60, mf.findMedian());
    }

    @Test
    public void test09() {
        mf.addNum(50);
        mf.addNum(60);
        mf.addNum(65);
        assertEquals(60, mf.findMedian());
    }


    @Test
    public void test10() {
        mf.addNum(60);
        mf.addNum(50);
        mf.addNum(40);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test11() {
        mf.addNum(60);
        mf.addNum(50);
        mf.addNum(50);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test12() {
        mf.addNum(60);
        mf.addNum(50);
        mf.addNum(55);
        assertEquals(55, mf.findMedian());
    }

    @Test
    public void test13() {
        mf.addNum(60);
        mf.addNum(50);
        mf.addNum(60);
        assertEquals(60, mf.findMedian());
    }

    @Test
    public void test14() {
        mf.addNum(60);
        mf.addNum(50);
        mf.addNum(65);
        assertEquals(60, mf.findMedian());
    }

    // 偶数，且值相等
    @Test
    public void test15() {
        mf.addNum(50);
        mf.addNum(50);
        mf.addNum(40);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test16() {
        mf.addNum(50);
        mf.addNum(50);
        mf.addNum(50);
        assertEquals(50, mf.findMedian());
    }

    @Test
    public void test17() {
        mf.addNum(50);
        mf.addNum(50);
        mf.addNum(60);
        assertEquals(50, mf.findMedian());
    }
}