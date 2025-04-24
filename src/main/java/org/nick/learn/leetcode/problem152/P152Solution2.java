package org.nick.learn.leetcode.problem152;

public class P152Solution2 {

    /**
     * 基于前一解法 优化空间复杂度
     */
    public int maxProduct(int[] nums) {
        int n= nums.length;

        int preMax = nums[0], preMin = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++){
            int val = nums[i];
            int tmp1 = preMax * val;
            int tmp2 = preMin * val;

            // 求当前位的最大值
            int tmp3 = Math.max(tmp1, tmp2);
            int curMax = Math.max(tmp3, val);

            // 求当前位的最小值
            int tmp4 = Math.min(tmp1, tmp2);
            int curMin = Math.min(tmp4, val);

            // 比较当前位的最大值和历史最大值，得出阶段性的答案
            max = Math.max(curMax, max);

            // 准备下一次迭代
            preMax = curMax;
            preMin = curMin;
        }

        return max;
    }
}
