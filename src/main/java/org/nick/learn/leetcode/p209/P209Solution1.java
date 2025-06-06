package org.nick.learn.leetcode.p209;

public class P209Solution1 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int sum = nums[0];
        Integer result = null;
        while (j < n) {
            if (sum < target) {
                j++;
                if (j >= n) {
                    break;
                }
                sum += nums[j];
            } else {
                result = (result == null)
                        ? (j - i + 1)
                        : (Math.min(result, j - i + 1));
                i++;
                if (i > j) {
                    j++;
                    if (j >= n) {
                        break;
                    }
                    sum += nums[j];
                }
                sum -= nums[i - 1];
            }
        }
        return result == null ? 0 : result;

    }
}
