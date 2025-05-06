package org.nick.learn.leetcode.p55;

/**
 * 力扣 55. 跳跃游戏
 */
public class P55Solution1 {

    // 回溯
    // 时间复杂度 O(n^2)
    // 空间复杂度 O(n) 栈空间
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int curIdx) {
        if (curIdx >= nums.length - 1) {
            return true;
        }
        for (int i = nums[curIdx]; i >= 1; ) {
            if (jump(nums, curIdx + i)) {
                return true;
            } else {
                i--;
            }
        }
        return false;
    }

}