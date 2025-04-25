package org.nick.learn.leetcode.p169;

/**
 * 力扣 169. 多数元素
 */
public class P169Solution3 {
    /**
     * 重温 Boyer-Moore 投票算法
     * 根据官方题解进行代码精简
     *
     * 时间复杂度 O(n)
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 1) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Integer i = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                i = num;
            }
            count += (num == i) ? 1 : -1;
        }
        return i;
    }
}
