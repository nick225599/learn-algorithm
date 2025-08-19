package org.nick.learn.leetcode.p137;

import java.util.HashMap;
import java.util.Map;

public class P137Solution4 {

    // 哈希表也算
    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // 哈希表不算吧。。。

    // 5ms, 击败21.22%
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int num : nums) {
            cache.put(num, cache.getOrDefault(num, 0) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException();
    }

}
