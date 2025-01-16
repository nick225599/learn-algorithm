package org.nick.learn.leetcode.problem41;

public class SolutionA {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int tag1 = n + 1; // 如果有缺失，缺失的正整数一定在 [1, n] 区间内

        // 将不在 [1, n] 范围内的数标记为 >n 的数
        for (int i = 0; i < n; i++) {
            // if (nums[i] < 1 || nums[i] > n) {
            if (nums[i] < 1) { // 剪支
                nums[i] = tag1;
            }
        }

        // 使用正负号，将 [1, n] 内的数标记为负号
        for (int i = 0; i < n; i++) {
            int tmp = nums[i];
            if (tmp < 0) {
                tmp = -tmp;
            }
            // if (1 <= tmp && tmp <= n) {
            if (tmp <= n) { // 剪支
                int index = tmp - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
        }

        // 遍历数组，如果当前数没有被标记为负数，说明原数组缺少这个数对应的下标
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 如果遍历完数组，所有的数都被标记为负数了，说明原数组没有缺失，那么最小正整数就是 n+1
        return n + 1;
    }
}
