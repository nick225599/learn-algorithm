package org.nick.learn.leetcode.p1;

import java.util.Arrays;

public class P1Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // 1. 剔除 > target 的数
        // 2. 剩余的数从小到大排序
        // 3. 双指针从两端向中间遍历
        //  3.1 如果和大于 target
        //  3.1A 左指针右移 1 位
        //  3.1B 右指针左移 1 位
        //  3.1C 左右指针都内移动 1 位
        //       若和还是大于 target 继续循环
        // 错的 可能要一直右缩进 或 左缩进
        int n = nums.length;
        int[] sortedNum = new int[n];
        System.arraycopy(nums, 0, sortedNum, 0, n);
        Arrays.sort(sortedNum);

        int i = 0, j = n - 1;
        while (i < j) {
            if (sortedNum[i] + sortedNum[j] == target) {
                break;
            }
            if (sortedNum[i + 1] + sortedNum[j] == target) {
                i = i + 1;
                break;
            }
            if (sortedNum[i] + sortedNum[j - 1] == target) {
                j = j - 1;
                break;
            }
            if (sortedNum[i + 1] + sortedNum[j - 1] == target) {
                i++;
                j--;
                break;
            }
            i++;
            j--;
        }
        int[] result = new int[2];
        for (int k = 0; k < n; k++) {
            if (sortedNum[i] == nums[k]) {
                result[0] = k;
            } else if (sortedNum[j] == nums[k]) {
                result[1] = k;
            }
        }
        return result;
    }

}
