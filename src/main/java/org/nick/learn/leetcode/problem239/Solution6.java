package org.nick.learn.leetcode.problem239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution6 {


    // 双端队列实现
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            //TODO nick 20250220 第一个测试按理就错了
            // nums=[1,-1]
            // k = 1
            // 预期[1, -1] 实际[1, 1]
            // 检查下哪里有问题
            while (null != deque.peekFirst() && deque.peekFirst() < element) {
                deque.pollFirst();
            }
            deque.offerFirst(element);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = deque.peekLast();
            }
        }
        return result;
    }
}
