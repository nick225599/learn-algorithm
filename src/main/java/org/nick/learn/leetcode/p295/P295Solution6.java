package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution6 {

    // 仿制官方题解二
    static class MedianFinder {

        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder() {
            nums = new TreeMap<>();
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = num;
                left[1] = right[1] = 1;
                n++;
                return;
            }

            if (n % 2 == 1) {
                if (num < left[0]) {
                    left[1]--;
                    if(left[1] == 0){
                        left[0] = nums.floorKey(left[0] - 1);
                        left[1] = nums.get(left[0]);
                    }
                } else if (num == left[0]) {
                    // 不知道要干啥
                } else if (left[0] < num) {
                    right[1] ++;
                    if(right[1] > nums.get(right[0])){
                        right[0] = nums.ceilingKey(right[0] + 1);
                        right[1] = 1;
                    }
                }
            } else {
                //TODO nick 仿制官方题解 2
                if (num <= left[0]) {

                } else if (right[0] <= num) {

                } else {

                }
            }


        }

        public double findMedian() {

        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

