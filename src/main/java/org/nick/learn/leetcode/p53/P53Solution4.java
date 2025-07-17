package org.nick.learn.leetcode.p53;

public class P53Solution4 {

    // 2ms 击败 37.95%
    // 灵光乍现版本，问题是，这尼玛也没啥通用性啊...
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] bitMax = new int[n];
        bitMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            bitMax[i] = Math.max(bitMax[i - 1] + nums[i], nums[i]); // 看了下题解，这就是 dp 思想...
        }

        int max = bitMax[0];
        for(int i = 1; i < n; i++){
            max = Math.max(max, bitMax[i]);
        }

        return max;
    }


}
