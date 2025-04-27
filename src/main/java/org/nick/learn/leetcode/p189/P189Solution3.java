package org.nick.learn.leetcode.p189;

/**
 * 力扣 189. 轮转数组
 */
public class P189Solution3 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * 还能有空间复杂度更低的解法吗？
     * 有的，用固定长度的临时空间来缓存要被覆盖的元素
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int count = 0;
        for (int j = 0; j < n && count < n; j++) {
            int tmp1 = nums[j];
            int i = j;
            do {
                i = (i + k) % n;
                int tmp2 = nums[i];
                nums[i] = tmp1;
                tmp1 = tmp2;
                count++;
            } while (i != j && count < n);
        }
    }


}
