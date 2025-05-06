package org.nick.learn.leetcode.p55;

/**
 * 力扣 55. 跳跃游戏
 */
public class P55Solution2 {

    // 贪心
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int curMaxIndex = 0;
        for(int i = 0; i < n; i++){
            if(i > curMaxIndex) {
                return false;
            }
            curMaxIndex = Math.max(curMaxIndex, i + nums[i]);
        }
        return true;
    }


}