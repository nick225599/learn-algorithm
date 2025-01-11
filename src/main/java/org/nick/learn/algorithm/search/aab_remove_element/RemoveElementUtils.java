package org.nick.learn.algorithm.search.aab_remove_element;


/**
 * 移除元素
 *
 * @see <a href="https://programmercarl.com/0027.移除元素.html">代码随想录-移除数组元素</>
 * @see <a href="https://leetcode.cn/problems/remove-element/">力扣 - 27. 移除元素</a>
 */
public class RemoveElementUtils {

    public static int removeElement(int[] nums, int val) {
        int resultLength = nums.length;
        for (int i = 0; i < resultLength; i++) {
            if (nums[i] == val) {
                for (int j = i; j < resultLength - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                resultLength--; // 找到一个目标值，新数组长度就 -1
                i--; // 后一个数组被前移了，所以需要 -1， 重新从当前位置进行查找
            }
        }
        return resultLength;
    }

    /**
     * 快指针负责查找，慢指针负责替换
     */
    public static int removeElementDoublePoint(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; // slow 指向下一个要存储的位置，所以 return 新数组 length 时不需要再 + 1
    }

    //TODO scs 20230903 相向双指针法
    public static int removeElementZueinanderDoublePoint(int[] nums, int val) {
        return -1;
    }
}
