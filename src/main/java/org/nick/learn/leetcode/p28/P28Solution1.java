package org.nick.learn.leetcode.p28;

/**
 * 力扣 80. 删除有序数组中的重复项 II
 */
public class P28Solution1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int rs = 0;
        int re = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[re]) {
                if (rs == re) {
                    nums[++re] = nums[i];
                }
            } else {
                ++re;
                rs = re;
                if (re < i) {
                    nums[re] = nums[i];
                }

            }
        }
        return re + 1;
    }


}
