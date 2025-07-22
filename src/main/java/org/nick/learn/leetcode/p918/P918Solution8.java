package org.nick.learn.leetcode.p918;

import java.util.ArrayDeque;
import java.util.Deque;

public class P918Solution8 {

    // 单调队列
    // 25ms 击败11%

    // 单调队列的核心价值是 **“用线性时间维护序列的单调性，实现范围最值的 O (1) 查询”**。
    // 无论是滑动窗口、前缀和优化、环形数组，还是动态规划中的状态转移，
    // 只要问题涉及 “在某个范围内快速找最大 / 最小值”，
    // 且序列满足一定的线性遍历特性，都可以考虑用单调队列解决。
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, nums[0]});
        int sumi = nums[0];
        int max = nums[0];
        for (int i = 1; i < (n << 1); i++) {
            while (!deque.isEmpty() && deque.peekFirst()[0] < i - n) {
                deque.pollFirst();
            }
            sumi += nums[i % n];
            int sumj = deque.peekFirst()[1];
            int delta = sumi - sumj;
            if (delta > max) {
                max = delta;
            }
            while (!deque.isEmpty() && deque.peekLast()[1] > sumi) {
                deque.pollLast();
            }
            deque.add(new int[]{i, sumi});
        }

        return max;

    }
}
