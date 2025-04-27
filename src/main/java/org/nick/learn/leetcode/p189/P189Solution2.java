package org.nick.learn.leetcode.p189;

/**
 * 力扣 189. 轮转数组
 */
public class P189Solution2 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * 还能有空间复杂度更低的解法吗？
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            newNums[(i + k) % n] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5
        int n = 5;
        int k = 6;
        int base = k % n;
        System.out.println("base: " + base);
    }

}
