package org.nick.learn.leetcode.p53;

public class P53Solution3 {

    // 2ms 击败 37.95%
    // 灵光乍现版本，问题是，这尼玛也没啥通用性啊...
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] values = new int[n];
        values[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            values[i] = Math.max(nums[i], nums[i] + values[i + 1]);
        }

        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i]);
        }

        return max;
    }


}
