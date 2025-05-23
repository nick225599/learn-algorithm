package org.nick.learn.leetcode.p219;

import java.util.HashMap;
import java.util.Map;

public class P219Solution3 {
    // 滑动窗口法
    //
    // 时间复杂度 O(n) 但相比于 Solution2 常数系数更高一些
    // 空间复杂度 O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> buff = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = buff.get(nums[i]);
            if (null != preIndex) {
                if (i - preIndex <= k) {
                    return true;
                }
            }
            // nums = [5,8,8,3]
            // k = 3
            // 当 i = 3 时，删除 i = 0 的元素
            // del-i = i - k
            if(i - k >= 0){
                buff.remove(nums[i - k]);
            }
            buff.put(nums[i], i);
        }
        return false;
    }
}
