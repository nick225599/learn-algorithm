package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution5 {

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/find-median-from-data-stream/solutions/961062/shu-ju-liu-de-zhong-wei-shu-by-leetcode-ktkst/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    // 官方题解二，有序集合 + 双指针
    // 没完全看懂，自己尝试写一下估计就能明白了
    static class MedianFinder {
        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder() {
            nums = new TreeMap<>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
            } else if (n % 2 == 1) {
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else {
                if (num <= left[0]) {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                } else if (num > left[0] && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (right[0] <= num) {
                    increase(left);
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

