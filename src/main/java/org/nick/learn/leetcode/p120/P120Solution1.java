package org.nick.learn.leetcode.p120;

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
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            for (int j = level.size() - 1; j >= 0; j--) {
                int val = level.get(j);
                if (j == 0) {
                    dp[j] = dp[j] + val;
                } else if (j == level.size() - 1) {
                    dp[j] = dp[j - 1] + val;
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + val;
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
