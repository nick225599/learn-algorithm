package org.nick.learn.algorithm.search.aaa_binary_search;

/**
 * 移除元素
 *
 * @see <a href="https://programmercarl.com/0027.移除元素.html">代码随想录-移除数组元素</>
 * @see <a href="https://leetcode.cn/problems/remove-element/">力扣 - 27. 移除元素</a>
 */
public class BinarySearchUtils {


    /**
     * [,]
     */
    public static int binarySearchLeftIncludeRightInclude(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) { // 要保证查找边界有意义，[1,1] 是有意义的
            middle = left + ((right - left) >> 1);
            if (target < nums[middle]) {
                right = middle - 1; // target 在左区间 [left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间 [middle + 1, right]
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * [,)
     */
    public static int binarySearchLeftIncludeRightExclude(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (target < nums[middle]) {
                right = middle;  // target 在左区间 [left, middle)
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间 [middle + 1, right)
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * (,]
     */
    public static int binarySearchLeftExcludeRightInclude(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + ((right - left) >> 1) + 1;
            if (target < nums[middle]) {
                right = middle -1 ; // target 在左区间 (left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle; // target 在右区间 (middle, right]
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int binarySearchLeftExcludeRightExclude(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left < right - 1) { // 要保证查找边界有意义，(0,1)只相差 1 是意义的，(0,2)才有意义
            int middle = left + ((right - left) >> 1);
            if (target < nums[middle]) {
                right = middle; // target 在左区间 (left, middle)
            } else if (nums[middle] < target) {
                left = middle; // target 在右区间 (middle, right)
            } else {
                return middle;
            }
        }
        return -1;
    }
}
