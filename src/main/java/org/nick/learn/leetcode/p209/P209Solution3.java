package org.nick.learn.leetcode.p209;

public class P209Solution3 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (j < n) {
            sum += nums[j];
            while (sum >= target) {
                result = Math.min(result, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
