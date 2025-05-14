package org.nick.learn.leetcode.p80;

/**
 * 力扣 80. 删除有序数组中的重复项 II
 */
public class P80Solution1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int rs = 0;
        int re = 0;
        for (int i = 1; i < n; i++) {
            // 1. 元素重复
            //    1.1 重复次数 < 2
            //    1.2 重复次数 >= 2
            // 2. 元素不重复
            if (nums[i] == nums[re]) {
                // 重复元素且重复次数 < 2，将重复元素复制到下一位
                if (re == rs) {
                    nums[++re] = nums[i];
                } else {
                    // 重复次数 >= 2 时，直接无视，继续遍历下一位
                }
            } else {
                // 非重复元素，则将其复制到下一位
                if (re < i) {
                    nums[++re] = nums[i];
                }
                // 然后重置重复去间
                rs = re;
            }
        }
        return re + 1;
    }


}
