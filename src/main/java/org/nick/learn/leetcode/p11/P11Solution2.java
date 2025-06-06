package org.nick.learn.leetcode.p11;

public class P11Solution2 {
    // 双指针
    // 时间复杂度 O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = -1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
