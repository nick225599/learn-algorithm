package org.nick.learn.leetcode.p295;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P295Solution1 {
}

class MedianFinder {

    List<Integer> list = new ArrayList<>();

    public MedianFinder() {}

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

