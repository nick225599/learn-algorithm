package org.nick.learn.leetcode.p42;

import java.util.ArrayDeque;
import java.util.Deque;

public class P42Solution3 {


    /**
     * 栈
     */
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int i0 = stack.pop();
                int h0 = height[i0];
                if (stack.isEmpty()) {
                    break;
                }
                int i1 = stack.peek();
                int h1 = height[i1];
                int tmpH = Math.min(h1, height[i]) - h0;
                int tmpW = i - i1 - 1;
                sum += (tmpH * tmpW);
            }
            stack.push(i);
        }
        return sum;
    }
}
