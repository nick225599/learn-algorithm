package org.nick.learn.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class P1Solution5 {

    // 空间复杂度 O( min(nums.length, target))
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> buff = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int diff = target - tmp;
            if (buff.containsKey(diff)) {
                return new int[]{i, buff.get(diff)};
            } else {
                // 可能有负数，不能加这个 diff >= 0 的判断
//                if (diff >= 0) {
                    buff.put(nums[i], i);
//                }
            }
        }
        return null;
    }


}
