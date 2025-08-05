package org.nick.learn.leetcode.p295;

import java.util.PriorityQueue;

public class P295Solution4 {


    // 模仿官方题解，在添加数据的时候始终保持中位数在最小堆，简化代码
    // 没有我不均衡堆的解法性能高，
    // 为了代码简洁，提前做了不必要的再均衡，这么看我也不是傻冒 9-9
    static class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            } else {
                if (num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                    if (minHeap.size() + 1 < maxHeap.size()) {
                        minHeap.offer(maxHeap.poll());
                    }
                } else {
                    minHeap.offer(num);
                    if (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }
                }
            }

        }

        public double findMedian() {
            if (maxHeap.isEmpty()) {
                return 0;
            }
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

