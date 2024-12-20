package org.nick.learn.algorithm.leetcode.problems2974;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

/**
 * 第 3 版，手写快排，双轴快排
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
        for (int i = startIdx + 1; mid < right; ) {
            if (nums[i] <= nums[startIdx]) {
                // swap left+1 <-> i
                ArrayUtils.swap(nums, left + 1, i);

                left++;
                mid++;
                i++;
            } else if (nums[i] < nums[endIdx]) {

                mid += 1;
                i++;
            } else {
                // swap right-1 <-> i
                ArrayUtils.swap(nums, right - 1, i);

                right--;
            }

            // swap right <-> p1
            ArrayUtils.swap(nums, right, startIdx);

            // swap mid <-> p2
            ArrayUtils.swap(nums, mid, endIdx);
        }


        System.out.println(Arrays.toString(nums));
        //TODO sunchuansheng 不行，研究下别人的源码吧
        throw new RuntimeException("-----------------");

        // 对三个分区进行再次排序


    }


    public static void main(String[] args) {
        int[] nums;

        nums = ArrayUtils.generateIntArray10();
        System.out.println("before sort: " + Arrays.toString(nums));
        new Solution5().dualPivotQuickSort(nums);
        System.out.println("after sort: " + Arrays.toString(nums));
        Assert.assertTrue(ArrayUtils.arrayIsAsc(nums));
        System.out.println();

        nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution5().numberGame(nums)));
    }
}