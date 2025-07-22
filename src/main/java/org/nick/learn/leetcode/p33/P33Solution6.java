package org.nick.learn.leetcode.p33;

public class P33Solution6 {

    // 民间 top0 解法，思路跟官方题解一致
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 传统二分法：if(nums[mid] >= target)
            if (checkRight(nums, target, mid)) { //如果nums[mid]在target的右边或nums[mid]==target，缩小右边界
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 判断nums[mid]是否在target的右边或nums[mid]==target?
     */
    private boolean checkRight(int[] nums, int target, int i) {
        int x = nums[i];
        int end = nums[nums.length - 1];
        if (x > end) {
            return target > end && target <= x;
            // x > end的时候，说明 x 在第一段中，target 必须在第一段中（否则 x 一定在 target 左边）且 target 必须小于等于 x 才能保证 x 在 target 的右边或 x == target
        }
        // x <= nums[n−1]的时候，说明 x 在第二段中（或者 nums 只有一段），target 必须在第一段 或 在第二段且 target 小于等于 x 才能保证 x 在 target 的右边或 x == target
        return target <= x || target > end;
    }
}
