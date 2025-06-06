package org.nick.learn.leetcode.p11;

public class P11Solution3 {
    // 双指针，进一步优化版本
    // 时间复杂度 O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = -1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] <= height[j]) {
                int h = height[i];
                while(++i < j && h >= height[i]){}
            } else {
                int h = height[j];
                while(i < --j && height[j] <= h){}
            }
        }
        return maxArea;
    }
}
