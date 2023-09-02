package org.nick.learn.algorithm.aaa_binary_search;

/**
 * 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * @see <a href="https://programmercarl.com/0704.二分查找.html">代码随想录-二分查找</>
 * @see <a href="https://leetcode.cn/problems/binary-search/">力扣 - 704. 二分查找</a>
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
