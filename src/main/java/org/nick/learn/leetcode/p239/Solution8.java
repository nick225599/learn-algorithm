package org.nick.learn.leetcode.p239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution8 {

    // 双端队列实现，调整下自己的代码实现
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            while (!deque.isEmpty() && nums[deque.peekFirst()] < element) {
                deque.pollFirst();
            }
            deque.offerFirst(i);
            if (i - k + 1 >= 0) {

                // 删除失效元素
                while(deque.peekLast() < i - k + 1){
                    deque.pollLast();
                }

                result[i - k + 1] = nums[deque.peekLast()];
            }
        }
        return result;
    }
}
