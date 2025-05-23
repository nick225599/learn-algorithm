package org.nick.learn.leetcode.p1;

public class P1Solution4 {

    public int[] twoSum(int[] nums, int target) {
        int[] buff = new int[target + 1]; // target = 6
        // [0, 1, 2, 3, 4, 5]
        // [N, N, 1, N, 2, N]
        // nums = [2, 4]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                int tmp = buff[nums[i]];
                if(tmp > 0){
                    return new int[]{tmp - 1, i};
                }
                buff[nums[i]] = i + 1;
                // nick 不行 nums[i] 会是负数，不能用数组下标的形式
            }
        }
        for (int i = 1; i < target + 1; i++) {
            if (buff[i] > 0 && buff[target - i] > 0) {
                return new int[]{buff[i] - 1, buff[target - i] - 1};
            }
        }
        return null;
    }



}
