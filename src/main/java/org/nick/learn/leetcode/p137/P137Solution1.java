package org.nick.learn.leetcode.p137;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P137Solution1 {

    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // 线性 常数空间，那只能求和
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return nums[0];
        }

        long l1 = 0;
        long l2 = 0;

        for (int num : nums) {
            int mask = 1 << num; // 超 int 上限了，这个解法不行
            if ((l1 & mask) == 0) {
                l1 = l1 | mask;
            } else {
                l2 = l2 | mask;
            }
        }



        // l1: 0b01
        // l2: 0b11
        int n = 0;
        while (l1 != 0) {
            if ((l1 & 1) == 1 && (l2 & 1) == 0) {
                return n;
            }

            // O(k) 时间复杂度，k 为 nums 中的最大值
            l1 = l1 >> 1;
            l2 = l2 >> 1;
            n++;
        }
        throw new RuntimeException();
    }

    // O(n) 空间复杂度
    // 6ms 击败7.58%
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException();
    }

    // O(nlogn) 时间复杂度
    // 3ms, 击败 38%
    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; ) {
            if (nums[i] == nums[i - 2]) {
                i += 3;

                if (i >= nums.length) {
                    return nums[nums.length - 1];
                }

            } else {
                if (nums[i] == nums[i - 1]) {
                    return nums[i - 2];
                } else {
                    return nums[i];
                }
            }
        }
        throw new RuntimeException();
    }
}
