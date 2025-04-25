package org.nick.learn.leetcode.p26;

import java.util.Arrays;

/**
 * 力扣 26. 删除有序数组中的重复项
 */
public class P26Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            // 如果当前值 == 慢指针值
            // 当前值++

            // 如果当前值 ！= 慢指针值
            if (nums[fast] != nums[slow]) {
                slow++;
                if(slow < fast){
                    nums[slow] = nums[fast];
                }
            }
            // 将当前值换至慢指针下一位
            // 慢指针++
            // 当前值++
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new P26Solution1().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
