package org.nick.learn.leetcode.p169;

/**
 * Boyer-Moore投票算法
 * <p>
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class SolutionF {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // 第 169 题有说 You may assume that the majority element always exists in the array.
        // 所以可以省去 O(n) 的验证 candidate 是否正确
//        count = 0;
//        for (int num : nums) {
//            if (num == baseNumber) {
//                count++;
//            }
//        }
//        if (count > nums.length / 2) {
//            return baseNumber;
//        }
//        throw new RuntimeException("majority element not exist");

        return candidate;
    }
}
