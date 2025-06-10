package org.nick.learn.leetcode.p56;

import java.util.ArrayList;
import java.util.List;

public class P56Solution5 {

    // 差分数组（Difference Array）解法
    public int[][] merge(int[][] intervals) {

        // 求出所有 interval 的右边界的最大值
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }

        int[] diff = new int[2 * max + 2];
        for (int[] nums : intervals) {
            diff[nums[0] * 2]++;
            diff[nums[1] * 2 + 1]--;
        }

        int sum = 0;
        int start = -1;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum != 0 && start == -1) {
                start = i;
            }
            if (sum == 0 && start != -1) {
                res.add(new int[]{start / 2, (i - 1) / 2});
                start = -1;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
