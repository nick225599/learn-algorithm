package org.nick.learn.leetcode.p162;

public class P162Solution1 {

    int peakIndex = -1;

    // 看似二分，实际时间复杂度还是 O(n)
    // 怎么二分？？？？

    // 0ms 击败 100%？？？？？
    // 但时间复杂度依旧是 O(n)
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        this.midIsPeak(nums, n, 0, n - 1);
        return peakIndex;
    }

    private void midIsPeak(int[] nums, int n, int l, int r) {
        if (peakIndex != -1 || l < 0 || l > r || r > n - 1) {
            return;
        }
        int m = ((r - l) >> 1) + l;
        if ((m == 0 || nums[m] > nums[m - 1])
                && (m == n - 1 || nums[m] > nums[m + 1])) {
            peakIndex = m;
        } else {
            midIsPeak(nums, n, l, m - 1);
            midIsPeak(nums, n, m + 1, r);
        }
    }

}
