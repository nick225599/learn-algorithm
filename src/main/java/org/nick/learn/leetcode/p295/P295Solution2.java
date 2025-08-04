package org.nick.learn.leetcode.p295;

import java.util.PriorityQueue;

public class P295Solution2 {
    static class MedianFinder {



        PriorityQueue<Integer> minStack = new PriorityQueue<>();
        PriorityQueue<Integer> maxStack = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public MedianFinder() {

        }

        public void addNum(int num) {
            int minStackSize = minStack.size();
            int maxStackSize;
            if (minStackSize == 0) {
                minStack.add(num);
            } else {
                maxStackSize = maxStack.size();
                if (minStackSize > maxStackSize) {
                    int minStackTop = minStack.peek();
                    if (num > minStackTop) {
                        minStack.poll();
                        minStack.add(num);
                        maxStack.add(minStackTop);
                    } else {
                        maxStack.add(num);
                    }

                } else if (minStackSize < maxStackSize) {
                    int maxStackTop = maxStack.peek();
                    if (num < maxStackTop) {
                        maxStack.poll();
                        maxStack.add(num);
                        minStack.add(maxStackTop);
                    } else {
                        minStack.add(num);
                    }
                } else {
                    if (num > minStack.peek()) {
                        minStack.add(num);
                    } else {
                        maxStack.add(num);
                    }
                }

            }

        }

        public double findMedian() {
            int minStackSize = minStack.size();
            int maxStackSize = maxStack.size();
            if (minStackSize == 0 && maxStackSize == 0) {
                return 0;
            }
            if (minStackSize > maxStackSize) {
                return minStack.peek();
            } else if (minStackSize < maxStackSize) {
                return maxStack.peek();
            } else {
                return (minStack.peek() + maxStack.peek()) / 2.0D;
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

