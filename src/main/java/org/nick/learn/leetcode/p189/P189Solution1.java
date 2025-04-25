package org.nick.learn.leetcode.p189;

/**
 * 力扣 189. 轮转数组
 */
public class P189Solution1 {

    /**
     * 直观解决问题，超出时间限制
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            int tmp = nums[n - 1];
            for (int i = n - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }
    }

}
