package org.nick.learn.leetcode.problem2974;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 对比自己写的插入排序，
 * 和 JDK 源码中的插入排序
 */
@Slf4j
public class Solution6A {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        this.insertionSort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    private void insertionSort(int[] nums) {
        for(int k = 1; k < nums.length; k++){
            int val = nums[k];

            int i = k;
            if(val < nums[i - 1]){
                while(--i >= 0 && val < nums[i]){
                    nums[i + 1] = nums[i];
                }
                nums[i + 1] = val;
            }
        }

//
//
//        if (nums.length <= 1) {
//            return;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            int j;
//            for (j = i - 1; j >= 0; j--) {
//                if (nums[j] > val) {
//                    nums[j + 1] = nums[j];
//                } else {
//                    break;
//                }
//            }
//            nums[j + 1] = val;
//        }
    }

    public static void main(String[] args) {
        Solution6A solutionInstance = new Solution6A();

        int[] nums;
        for (int i = 0; i < 10000; i++) {
            nums = ArrayUtils.generateIntArray10();
            log.info("before sort: {}", Arrays.toString(nums));


            // 自己实现的插入排序
            solutionInstance.insertionSort(nums);

            // JDK 源码中的插入排序
//            Solution6A.insertionSortJDKVariant(nums);

            log.info("after sort: {}", Arrays.toString(nums));
            Assert.assertTrue(ArrayUtils.arrayIsAsc(nums));
            log.info("");
        }


    }


    /**
     * JDK 中的插入排序实现，源代码参见：
     * java.util.DualPivotQuicksort#insertionSort(int[], int, int)
     */
    private static void insertionSortJDK(int[] a) {
        Solution6A.insertionSortJDK(a, 0, a.length);
    }

    /**
     * Sorts the specified range of the array using insertion sort.
     *
     * @param a    the array to be sorted
     * @param low  the index of the first element, inclusive, to be sorted
     * @param high the index of the last element, exclusive, to be sorted
     */
    private static void insertionSortJDK(int[] a, int low, int high) {
        for (int i, k = low; ++k < high; ) {
            int ai = a[i = k];

            if (ai < a[i - 1]) {
                while (--i >= low && ai < a[i]) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }

    private static void insertionSortJDKVariant(int[] a) {
        for (int i, k = 0; ++k < a.length; ) {
            int ai = a[i = k];

            if (ai < a[i - 1]) {
                while (--i >= 0 && ai < a[i]) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        }
    }
}