package org.nick.learn.leetcode.p918;

import java.util.Arrays;

public class P918Solution5 {

    // dp
    // 时间复杂度  O(n)
    // 空间复杂度 O(n)

    // 怎么优化下常数系数？
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int[] arr1 = new int[n]; // 以 i 为下标，表示 nums[i, n - 1] 的元素和
        arr1[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr1[i] = nums[i] + arr1[i + 1];
        }
        System.out.println("arr1: " + Arrays.toString(arr1));

        int[] arr2 = new int[n]; // 以 i 为下标，表示 nums[0, i] 的以 0 为左边界的子数组的最大和
        int[] tmpArr2 = new int[n]; // nums[0, i] 的元素和
        arr2[0] = nums[0];
        tmpArr2[0] = nums[0];

        int pre = nums[0];
        int max = nums[0];

        int[] arr3 = new int[n];
        arr3[0] = max;
        for (int i = 1; i < n; i++) {
            tmpArr2[i] = tmpArr2[i - 1] + nums[i];
            // [0, i] 的最大前缀和 = [0, i - 1] 最大前缀和 或 [0, i-1]的和 + 当前位
            arr2[i] = Math.max(arr2[i - 1], tmpArr2[i - 1] + nums[i]);

            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);

            // [i,n-1] 的元素和 + [0, i-1]以 0  为左边界的子数组最大和
            // = 跨右边界的子数组的最大和 [i, n - 1] & [0, i - 1]
            arr3[i] = arr1[i] + arr2[i - 1];

            max = Math.max(max, arr3[i]);

        }


        return max;
    }


}
