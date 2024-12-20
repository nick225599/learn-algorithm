package org.nick.learn.algorithm.leetcode.problems2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

/**
 * 使用插入排序实现力扣 2974. Minimum Number Game
 */
@Slf4j
class Solution6B {
    public int[] numberGame(int[] nums) {
        // 插入排序
        this.insertionSort(nums);

        // 一对一对取出
        for (int i = 1; i < nums.length; i += 2) {
            ArrayUtils.swap(nums, i, i - 1);
        }

        return nums;
    }

    private void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            int k = i - 1;
            if (val < nums[k]) {
                while (k-- >= 0 && val < nums[k]) {
                    nums[k + 1] = nums[k];
                }
                nums[k + 1] = val;
            }

        }
    }

    public static void main(String[] args) {
        Solution6B solutionInstance = new Solution6B();
        int[] nums;

        nums = new int[]{5, 4, 2, 3};
        solutionInstance.numberGame(nums);
        Assert.assertArrayEquals(new int[]{3, 2, 5, 4}, nums);


        nums = new int[]{2, 5};
        solutionInstance.numberGame(nums);
        Assert.assertArrayEquals(new int[]{5, 2}, nums);


    }
}