package org.nick.learn.leetcode.problem239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution7  {

    // 官方的双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast(); // 被 poll 的是 nums[1] 刚好是下一个窗口的最大值，咋办
                // [3, 0, -2, -1]
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans; // 跟我一开始的思路是一致的，我的咋不行？
    }
}

