package org.nick.learn.leetcode.p2974;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用插入排序实现力扣 2974. Minimum Number Game
 */
@Slf4j
class Solution6B {
    public int[] numberGame(int[] nums) {

        // 插入排序
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            int k = i - 1;
            if (val < nums[k]) {
                while (k >= 0 && val < nums[k]) {
                    nums[k + 1] = nums[k];
                    k--;
                }
                nums[k + 1] = val;
            }
        }

        // 两个两个地取出，并交换位置
        for (int i = 1; i < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }

        return nums;
    }


    public void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            int k = i - 1;
            if (val < nums[k]) {
                while (k >= 0 && val < nums[k]) {
                    nums[k + 1] = nums[k];
                    k--;
                }
                nums[k + 1] = val;
            }
        }
    }

    public static void main(String[] args) {


    }
}