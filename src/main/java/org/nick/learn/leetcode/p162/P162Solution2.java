package org.nick.learn.leetcode.p162;

public class P162Solution2 {

    // 怎么二分？？？？
    // 山峰元素一定是存在的，这就可以二分
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = ((r - l) >> 1) + l;
            // m + 1 不可能下标溢出
            if (nums[m] < nums[m + 1]) {
                // peak 在 [m + 1, r]
                l = m + 1;
            } else {
                // peak 在 [l, m]
                r = m;
            }
        }
        return l;
    }


}
