package org.nick.learn.leetcode.problem2974;

import org.junit.Assert;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 手搓双轴快排
 */
public class Solution5 {
    public int[] numberGame(int[] nums) {
        this.dualPivotQuickSort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    private void dualPivotQuickSort(int[] nums) {
        this.dualPivotQuickSort(nums, 0, nums.length - 1);

    }

    private void dualPivotQuickSort(int[] nums, int startIdx, int endIdx) {
        // 退出机制，开始和结束索引是同一个
        if (startIdx >= endIdx) {
            return;
        }

        // 判断两个端点是否 <
        if (nums[startIdx] > nums[endIdx]) {
            ArrayUtils.swap(nums, startIdx, endIdx);
        }

        if (startIdx + 1 >= endIdx) {
            return;
        }

        // 根据两个端点进行分区
        //
        // -------- p1 ----------------- p2 --------
        //
        // -------- | -------- | ------- | ---------
        //  min     |   mid    | ?       | max
        // -------- | -------- | ------- | ---------
        //          ^          ^         ^
        //          |          |         |
        //         left        i        super
        //         <= p1       <= p2      > p2

        int left = startIdx;
        int mid = startIdx;
        int right = endIdx;
        for (int i = startIdx + 1; i < right; ) {
            if (nums[i] <= nums[startIdx]) {
                // swap left+1 <-> i
                if (left < mid) {
                    ArrayUtils.swap(nums, left + 1, i);
                }

                left++;
                mid++;
                i++;
            } else if (nums[i] < nums[endIdx]) {

                mid += 1;
                i++;
            } else {
                // swap right-1 <-> i
                if (i + 1 < right) {
                    ArrayUtils.swap(nums, right - 1, i);
                }

                right--;
            }
        }
        // swap right <-> p1
        if (startIdx < left) {
            ArrayUtils.swap(nums, left, startIdx);
        }
        if (right < endIdx) {
            ArrayUtils.swap(nums, right, endIdx);
        }


        // 对三个分区进行再次排序
        this.dualPivotQuickSort(nums, startIdx, left - 1);
        this.dualPivotQuickSort(nums, left + 1, right - 1);
        this.dualPivotQuickSort(nums, right + 1, endIdx);

    }


    public static void main(String[] args) {
        int[] nums;

        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            System.out.println("before sort: " + Arrays.toString(nums));
            new Solution5().dualPivotQuickSort(nums);
            System.out.println("after sort: " + Arrays.toString(nums));
            Assert.assertTrue(ArrayUtils.arrayIsAsc(nums));
            System.out.println();
        }

        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution5().numberGame(nums)));
    }
}