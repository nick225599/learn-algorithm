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
        while (left <= right) {
            middle = left + ((right - left) / 2);
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
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
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + ((r - l) / 2);
            if (target < nums[m]) {
                r = m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchLeftExcludeRightInclude(int[] numbers, int target) {
        return -1;
    }

    public static int binarySearchLeftExcludeRightExclude(int[] numbers, int target) {
        return -1;
    }
}
