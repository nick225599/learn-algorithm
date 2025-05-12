package org.nick.learn.leetcode.p42;

public class P42Solution4 {


    /**
     * 双指针法
     */
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                if(Math.min(lMax, rMax) > height[l]){
                    sum+=(Math.min(lMax, rMax) - height[l]);
                }
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                if(Math.min(lMax, rMax) > height[r]){
                    sum+=(Math.min(lMax, rMax) - height[r]);
                }
            }


        }
        return sum;
    }
}
