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
        TreeMap<Integer, Integer> treeMap;
        int n;
        int[] left;
        int[] right;

        public MedianFinder() {
            treeMap = new TreeMap<>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {

            // key 是数字，value 是数量
            //TODO 跟指针 left right 怎么关联上？？？
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1; //TODO 为啥需要第 2 套指针？ 为啥是值 1？
            } else if (isOdd(n)) {
                // 有序集合为中元素为奇数时，left 和 right 同时指向中位数。
                // 如果 num 小于等于中位数，那么只要让 left 左移，否则让 right 右移即可。
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else {
                if (left[0] < num && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (right[0] <= num) {
                    increase(left);
                } else if (num < left[0]) {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            n++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] arr) {
            arr[1]++;
            if (arr[1] > treeMap.get(arr[0])) {
                arr[0] = treeMap.ceilingKey(arr[0] + 1);
                arr[1] = 1;
            }
        }

        private void decrease(int[] arr) {
            arr[1]--;
            if (arr[1] == 0) {
                arr[0] = treeMap.floorKey(arr[0] - 1);
                arr[1] = treeMap.get(arr[0]);
            }
        }

        private boolean isOdd(int n) {
            return (n & 1) == 1;
        }

        private boolean isEven(int n) {
            return !isOdd(n);
        }
    }


}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

