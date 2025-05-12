package org.nick.learn.leetcode.p42;

public class P42Solution2 {


    /**
     * dp 用空间来降低复杂度
     * 原理：对于下标 i，
     * 下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
     * 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
     *
     */
    public int trap(int[] height) {
        int n  = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i - 1], height[i]);
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += (Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}
