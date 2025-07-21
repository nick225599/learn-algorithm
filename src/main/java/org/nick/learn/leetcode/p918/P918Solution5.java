package org.nick.learn.leetcode.p918;

import java.util.Arrays;

public class P918Solution5 {

    // dp
    // 时间复杂度  O(n)
    // 空间复杂度 O(n)

    // 怎么优化下常数系数？
    // 6ms 击败 69%
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

//        int[] arr0 = new int[n]; // 以 i 为下标，表示 nums[0, i] 的元素和
//        int[] arr1 = new int[n]; // 以 i 为下标，表示 nums[i, n - 1] 的元素和
//        int[] arr2 = new int[n]; // 以 i 为下标，表示 nums[0, i] 的以 0 为左边界的子数组的最大和
        int[] arr3 = new int[n]; // 以 i 为下标，表示 nums[i, n - 1] & [0, i - 1] 子数组的最大和

        int arr0 = nums[0];
        int arr1 = sum;
        int arr2 = nums[0];
        arr3[0] = nums[0];

        int pre = nums[0];
        int max = nums[0];

        int finalMax = nums[0];

        for (int i = 1; i < n; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);

            arr1 = sum - arr0;


            // [i,n-1] 的元素和 + [0, i-1]以 0  为左边界的子数组最大和
            // = 跨右边界的子数组的最大和 [i, n - 1] & [0, i - 1]
            arr3[i] = arr1 + arr2;
            // [0, i] 的最大前缀和 = [0, i - 1] 最大前缀和 或 [0, i-1]的和 + 当前位
            arr2 = Math.max(arr2, arr0 + nums[i]);
            finalMax = Math.max(finalMax, arr3[i]);


            arr0 = arr0 + nums[i];
        }
        finalMax = Math.max(finalMax, max);
        return finalMax;
    }


}
