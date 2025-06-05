package org.nick.learn.leetcode.p167;

public class P167Solution2 {
    // 双指针
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};

                // 为啥不会错过正确答案或者陷入查找区间来回往复陷入死循环？

//                假设正确答案为下标 i 和 j（i < j），则在双指针遍历过程中：
//
//                当左指针 left 到达 i 时，
//                右指针 right 必然位于 j 或其右侧（因为初始时 right 从数组末尾开始，
//                且在 left 到达 i 之前，right 可能因 sum > target 向左移动，
//                但不会越过 j，否则会导致 sum < target，从而使 left 右移）。
//                此时，若 right 恰好等于 j，则直接返回；否则，right 会继续左移直至到达 j。
//
//                同理，当右指针 right 到达 j 时，左指针 left 必然位于 i 或其左侧，随后 left 会右移直至到达 i。

            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;

    }
}
