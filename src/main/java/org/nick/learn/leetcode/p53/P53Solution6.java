package org.nick.learn.leetcode.p53;

public class P53Solution6 {

    // 分支法
    // 有点跟第 148 题链表排序神似
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] arr =  maxSubArray(nums, 0, n - 1);
        return arr[2];
    }

    // 找最大值
    private int[] maxSubArray(int[] nums, int i, int j) {
        if (i == j) {
            // 分无可分
            return new int[] {nums[i], nums[i], nums[i], nums[i]};

        } else{

            // 分
            int mid = i + ((j - i) >> 1);
            int[] left = maxSubArray(nums, i, mid);
            int[] right = maxSubArray(nums, mid + 1, j);

            // 以 i 为左端点的最大子数组的和
            // = subL.整个数组的和 + subR.以 i 为左端点的最大子数组的和
            int i0 = left[3] + right[0];

            // 以 j 为右端点的最大子数组的和
            // = subL.以 j 为右端点的最大子数组的和 + subR.整个数组的和
            int i1 = left[1] + right[3];

            // [i, j] 数组中最大子数组的和
            // = subL.最大和，subR.最大和，subL.以 j 为右端点的最大和 + subR.以 i 为左端点的最大和
            // 三者取最大值
            int i2 = Math.max(
                    Math.max(left[2], right[2]),
                    left[1] + right[0]
            );

            // 整个数组的和
            int i3 = left[3] + right[3];

            // 合并
            return new int[]{i0, i1, i2, i3};
        }
    }


}
