package org.nick.learn.leetcode.p295;

import java.util.TreeMap;

public class P295Solution6 {

    // 仿制官方题解二
    static class MedianFinder {

        TreeMap<Integer, Integer> nums;
        int n;

        // 在这段代码中，left[1] 和 right[1] 用于跟踪「当前指针指向的数值的具体位置」，
        // 具体来说，它们代表的是 对应数值（left[0] 或 right[0]）在数据集中的第几个实例（从 1 开始计数）。
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
            } else if (n % 2 == 1) {
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else if (n % 2 == 0) {
                if (num < left[0]) {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                } else if (left[0] == num) {
                    // [50, 50]
                    // 50 50
                    // 1  2

                    // add(50)

                    // [50, 50, 50]
                    // 50, 50
                    // 2, 2
                    increase(left);
                    // 或
//                    System.arraycopy(right, 0, left, 0, 2);
                } else if (left[0] < num && num < right[0]) {
                    // [50, 60]
                    // 50 60
                    // 1  1

                    // add(55)

                    // [50, 55, 60]
                    // 55, 55
                    // 1, 1
                    increase(left);
                    decrease(right);
                    // 或
//                    left[0] = right[0] = num;
//                    left[1] = right[1] = 1;

                } else if (right[0] == num) {
                    // [40, 50]
                    // 40 50
                    // 1  1

                    // add(50)

                    // [40, 50, 50]
                    // 50, 50
                    // 1, 1
                    increase(left);
                    // 或
//                    System.arraycopy(right, 0, left, 0, 2);

                } else if (right[0] < num) {
                    // [40, 50]
                    // 40 50
                    // 1  1

                    // add(60)

                    // [40, 50, 60]
                    // 50, 50
                    // 1, 1
                    increase(left);
                    // 或
//                    System.arraycopy(right, 0, left, 0, 2);
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

