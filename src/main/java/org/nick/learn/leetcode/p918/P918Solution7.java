package org.nick.learn.leetcode.p918;

public class P918Solution7 {

    // 3ms 击败 98%
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int pre1, max1, pre2, min2, sum;
        pre1 = max1 = pre2 = min2 = sum = nums[0];
        for (int i = 1; i < n; i++) {
            pre1 = pre1 < 0 ? nums[i] : nums[i] + pre1; //  Math.max(nums[i], nums[i] + pre1);
            if (pre1 > max1) {
                max1 = pre1;
            }

            pre2 = pre2 > 0 ? nums[i] : nums[i] + pre2; // Math.min(nums[i], nums[i] + pre2);
            if (pre2 < min2) {
                min2 = pre2;
            }

            sum += nums[i];
        }
//        if (max1 < 0) {
//            return max1;
//        } else {
//            int max2 = sum - min2;
//            return max2 > max1 ? max2 : max1;
//        }
        return max1 < 0 ? max1 : Math.max(max1, sum - min2);
    }


}
