package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution6 {

    // 仿制官方题解二
    static class MedianFinder {

        int smaller;
        int smallerCount = 0;

        int larger;
        int largerCount = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = 0;


        public MedianFinder() {
        }

        public void addNum(int num) {
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }

            if (n == 0) {
                smaller = num;
                smallerCount = 1;
            } else if (n % 2 == 0) {
                if (num <= smaller) {
                    smallerCount--;
                    if (smallerCount == 1) {
                        larger = smaller;
                    } else if (smallerCount == 0) {
                        larger = smaller;
                        smaller = treeMap.ceilingKey(smaller);
                        smallerCount = treeMap.get(smaller);
                    }
                } else {
                    //TODO nick 自己写不出来，看官方题解吧，感觉两个数倒来倒去挺烦的
                }
            } else {
                if (num <= smaller) {

                } else {

                }
            }

            n++;
        }

        public double findMedian() {
            if (smallerCount == largerCount) {
                return (smaller + larger) / 2.0D;
            } else {
                return smaller;
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

