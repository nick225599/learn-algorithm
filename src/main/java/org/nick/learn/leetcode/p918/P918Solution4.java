package org.nick.learn.leetcode.p918;

import java.util.Arrays;

public class P918Solution4 {

    // dp
    // 时间复杂度  O(n)
    // 空间复杂度 O(n)
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

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
        for (int i = 1; i < n; i++) {
            tmpArr2[i] = tmpArr2[i - 1] + nums[i];
            // [0, i] 的最大前缀和 = [0, i - 1] 最大前缀和 或 [0, i-1]的和 + 当前位
            arr2[i] = Math.max(arr2[i - 1], tmpArr2[i - 1] + nums[i]);
        }
        System.out.println("arr2: " + Arrays.toString(arr2));

        // [0, n-1] 的最大子数组和
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);
        }
        System.out.println("max of [0, n - 1]: " + max);

        int[] arr3 = new int[n];
        arr3[0] = max;
        for (int i = 1; i <= n - 1; i++) {
            // [i,n-1] 的元素和 + [0, i-1]以 0  为左边界的子数组最大和
            // = 跨右边界的子数组的最大和 [i, n - 1] & [0, i - 1]
            arr3[i] = arr1[i] + arr2[i - 1];
        }
        System.out.println("arr3: " + Arrays.toString(arr3));

        // 找到最大值
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr3[i]);
        }
        System.out.println("final max: " + max);

        return max;
    }


}
