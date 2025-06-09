package org.nick.learn.leetcode.p128;

import java.util.HashSet;
import java.util.Set;

public class P128Solution2 {

    // 怎么才能时间复杂度 O(n) ???
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            set.add(num);
        }

        // 看似 O(n^2) 实则 O(n)
        int maxCount = Integer.MIN_VALUE;
        for (int num : set) {
            if (!set.contains(num - 1)) { // 当前数字是一个区间的起始位置
                int i = 1;
                while (set.contains(num + i)) {
                    i++;
                }
                maxCount = Math.max(maxCount, i);
            }
        }
        return maxCount;

    }
}
