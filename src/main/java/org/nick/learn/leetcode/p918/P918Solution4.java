package org.nick.learn.leetcode.p918;

public class P918Solution4 {

    // dp
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n]; // 以 i 为下标，表示 nums[i, n - 1] 的元素和
        for(int i = 0; i < n; i++){
            //TODO nick 20250718 回家写
        }

        int[] arr2 = new int[n]; // 以 i 为下标，表示 nums[0, i] 的以 0 为左边界的子数组的最大和
        for(int i = 0; i < n; i++){

        }
        int pre = nums[0];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                pre = Math.max(nums[i], nums[i] + pre);
                max = Math.max(max, pre);
            }


        }

    }


}
