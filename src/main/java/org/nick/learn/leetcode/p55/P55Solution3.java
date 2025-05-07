package org.nick.learn.leetcode.p55;

/**
 * 力扣 55. 跳跃游戏
 */
public class P55Solution3 {

    // dp
    // 时间复杂度 O(n^2)
    // 空间复杂度 O(n)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if(i + j < n){
                    boolean b1 = dp[i];
                    boolean b2 = dp[i + j];
                    if(b1 && !b2){
                        dp[i + j] = true;
                    }
                }
            }
        }
        return dp[n - 1];
    }


}