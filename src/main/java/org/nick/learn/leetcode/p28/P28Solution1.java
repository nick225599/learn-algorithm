package org.nick.learn.leetcode.p28;

import java.util.Arrays;

/**
 * 力扣 80. 删除有序数组中的重复项 II
 */
public class P28Solution1 {
    public int removeDuplicates(int[] nums) {
        int repeatStart = 0;
        int repeatEnd = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[repeatEnd]) {
                repeatStart = repeatEnd = i;
                continue;
            }

            repeatEnd = i;
            if (repeatEnd - repeatStart > 1) {
                if (i + 1 < nums.length) {
                    nums[repeatEnd] = nums[i + 1];
                }
            }
        }
        return repeatEnd + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2};
        System.out.println(new P28Solution1().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
