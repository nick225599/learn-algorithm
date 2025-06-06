package org.nick.learn.leetcode.p11;

public class P11Solution1 {
    // 时间复杂度 O(n^2)
    // 怎么优化？？？？
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
