package org.nick.learn.leetcode.p152;

public class P152Solution3 {

    /**
     * 评论区看到的“前后缀乘积法”
     *
     * 时间复杂度 O(n)，空间复杂度 O(1)，与 P152Solution2 动态规划一样
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int ans = Integer.MIN_VALUE;

        int tmp = 1;

        //正向遍历
        for (int num : nums) {
            if (num == 0) {
                ans = Math.max(ans, 0);
                tmp = 1;
                continue;
            }
            tmp *= num;
            ans = Math.max(ans, tmp);
        }

        //逆向遍历

        // 必须有逆向遍历，理由：
        // 假设有数组 [4, -2, 3, 2]
        // 正向遍历时 tmp: 4 => -8 => -24 => -48，最大值 4
        // 逆向遍历时 tmp: 2 => 6 => -12 => -48，最大值 6
        // 此时奇数个数的负数将乘积符号反转，通过逆序遍历，可以修正这一符号反转带来的计算谬误
        // 如果不通过逆序遍历，只想遍历一次得出结果，那就只要记录符号变化的影响了，也就是解法 1 和 解法 2
        tmp = 1;
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] == 0) {
                ans = Math.max(ans, 0);
                tmp = 1;
                continue;
            }
            tmp *= nums[i];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
