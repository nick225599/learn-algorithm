package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution6 {

    // 仿制官方题解二
    // 双堆法 或 有序集合+双指针法，空间复杂度都是 O(n)，
    // 但是如果数据基本不重复，则有序集合法存在一定的空间利用率不足。
    // 但如果数据存在大量重复元素，则有序集合空间利用率能够大幅降低，达到类似计数排序的效果
    static class MedianFinder {

        TreeMap<Integer, Integer> nums;
        int n;

        // 在这段代码中，left[1] 和 right[1] 用于跟踪「当前指针指向的数值的具体位置」，
        // 具体来说，它们代表的是 对应数值（left[0] 或 right[0]）在数据集中的第几个实例（从 1 开始计数）。
        int[] left;
        int[] right;

        public MedianFinder() {
            nums = new TreeMap<>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        // 时间复杂度：
        // 双堆法 O(logn)
        // 有序列表+双指针 O(logn) 耗在 hash map 的 get 和 put 方法里
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
            } else if (n % 2 == 0) {
                if (num <= left[0]) {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                } else if (left[0] < num && num < right[0]) {
                    left[0] = right[0] = num;
                    left[1] = right[1] = 1;
                } else {
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            n++;
        }

        // 时间复杂度
        // 双堆法和有序列表双指针法都是 O(1)
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

