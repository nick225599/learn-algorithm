package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution6 {

    // 仿制官方题解二
    static class MedianFinder {

        TreeMap<Integer, Integer> nums;
        int n;
        int[] left = new int[2];
        int[] right = new int[2];

        public MedianFinder() {
            nums = new TreeMap<>();
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
            } else if (n % 2 == 0) {
                if (num < left[0]) {
                } else if (num == left[0]) {
                } else if (left[0] < num && num < right[0]) {
                } else if (right[0] == num) {
                } else if (right[0] < num) {
                }
            } else if (n % 2 == 1) {
                if (num < left[0]) {
                } else if (left[0] == num) {
                } else if (left[0] < num && num < right[0]) {
                } else if (right[0] == num) {
                } else if (right[0] < num) {
                }
            }
            n++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] iterator) {
            iterator[1]++;
            if (iterator[1] > nums.get(iterator[0])) {
                iterator[0] = nums.ceilingKey(iterator[0] + 1);
                iterator[1] = 1;
            }
        }

        private void decrease(int[] iterator) {
            iterator[1]--;
            if (iterator[1] == 0) {
                iterator[0] = nums.floorKey(iterator[0] - 1);
                iterator[1] = nums.get(iterator[0]);
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

