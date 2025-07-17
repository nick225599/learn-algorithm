package org.nick.learn.leetcode.p53;

public class P53Solution4 {

    // 2ms 击败 37.95%
    // 灵光乍现版本，问题是，这尼玛也没啥通用性啊...
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1] + nums[i], nums[i]);
        }

        int max = left[0];
        for(int i = 1; i < n; i++){
            max = Math.max(max, left[i]);
        }

        return max;
    }


}
