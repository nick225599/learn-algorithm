package org.nick.learn.leetcode.p912;

import java.util.Arrays;

public class P912Solution10 {

    public static void main(String[] args) {
        //TODO nick 20250728 分析一下为什么只有
        //         quicksort(nums, l, j);
        //        quicksort(nums, j + 1, r);
        // 这一种正确的分区方案？
        P912Solution10 solution = new P912Solution10();
        int[] arr = new int[]{1, 2, 3, 4};
        solution.sortArray(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4, 3, 2, 1};
        solution.sortArray(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4, 4, 4, 4};
        solution.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l == r) return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            // 为什么 solution10 相比于 solution9 不会超时
            // 快速排序的效率取决于分区平衡性（是否能将数组均匀分为两部分），而分区平衡性很大程度上由重复元素的处理方式决定。
            //
            // Solution9 的问题：
            // 左指针i会跳过所有等于基准的元素（因nums[i] <= pivot），右指针j也会跳过所有等于基准的元素（因nums[j] >= pivot）。
            // 最终，i会直接移到右边界外，j会移到左边界，导致分区点j靠近左端点。此时递归会退化为 “每次仅减少一个元素”，时间复杂度从O(n log n)退化到O(n²)（最坏情况）。
            //
            // Solution10 的优化：
            // 左指针i遇到等于基准的元素时会停下（因nums[i] < x不成立），右指针j遇到等于基准的元素时也会停下（因nums[j] > x不成立）。
            // 此时若i < j，交换等于基准的元素（无实际意义，但会推动指针继续向中间移动），最终分区点j会落在数组中间，保证分区平衡。即使全是重复元素，仍能保持O(n log n)的时间复杂度。
            //
            // 在随机分布的数组中，两种解法的分区平衡性差异不大。但在极端情况（如接近有序、大量重复元素）下，Solution10 的分区方式更稳定，能避免递归深度过大（始终保持O(log n)的递归深度），而 Solution9 可能因分区倾斜导致递归深度增至O(n)。
            do {
                i++;
            } while (nums[i] < x);

            do {
                j--;
            } while (nums[j] > x);

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // Solution10 的递归区间 [l, j] 和 [j+1, r] 是严格匹配其分区逻辑的（左区间 ≤ 基准，右区间 ≥ 基准），直接修改会破坏这种匹配关系，导致元素遗漏或错误划分，最终排序失败。
        quicksort(nums, l, j);
        quicksort(nums, j+ 1, r);
    }
}
