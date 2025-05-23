package org.nick.learn.leetcode.p219;

import java.util.HashMap;
import java.util.Map;

public class P219Solution2 {
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> buff = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = buff.get(nums[i]);
            if (null != preIndex) {
                if (i - preIndex <= k) {
                    return true;
                }
            }
            buff.put(nums[i], i);
        }
        return false;
    }
}
