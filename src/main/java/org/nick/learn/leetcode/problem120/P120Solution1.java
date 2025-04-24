package org.nick.learn.leetcode.problem120;

import java.util.List;

/**
 * 力扣 120. 三角形最小路径和
 * @see <a href="https://leetcode.cn/problems/triangle/description/">力扣 120. 三角形最小路径和</a>
 */
public class P120Solution1 {

    /**
     * 动态规划
     *
     * 时间复杂度 O(N) ，N： trangle 里所有的元素格式
     * 空间复杂度 O(n) ，n: trangle 三角底边的元素个数
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.getLast().size()];
        dp[0] = triangle.getFirst().getFirst();
        for (int l = 1; l < triangle.size(); l++) {
            List<Integer> level = triangle.get(l);
            for (int i = level.size() - 1; i >= 0; i--) {
                int val = level.get(i);
                if (i == 0) {
                    dp[i] = dp[i] + val;
                } else if (i == level.size() - 1) {
                    dp[i] = dp[i - 1] + val;
                } else {
                    dp[i] = Math.min(dp[i - 1], dp[i]) + val;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.getLast().size(); i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
