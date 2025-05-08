package org.nick.learn.leetcode.p238;

/**
 * 力扣 238. 除自身以外数组的乘积
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150">力扣 238. 除自身以外数组的乘积</a>
 */
public class P238Solution2 {

    /**
     * 按照官方题解进行优化
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product;

        int[] r = new int[n];
        product = 1;
        for (int i = 0; i < n - 1; i++) {
            product *= nums[i];
            r[i] = product;
        }

        product = nums[n - 1];
        r[n - 1] = r[n - 2];
        for (int i = n - 2; i > 0; i--) {
            r[i] = r[i - 1] * product;
            product *= nums[i];
        }
        r[0] = product;

        return r;
    }
}
