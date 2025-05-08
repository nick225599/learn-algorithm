package org.nick.learn.leetcode.p238;

/**
 * 力扣 238. 除自身以外数组的乘积
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150">力扣 238. 除自身以外数组的乘积</a>
 */
public class P238Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;

        int[] dp1 = new int[n];
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            dp1[i] = product;
        }

        product = 1;
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            dp2[i] = product;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) {
                result[i] = dp2[i + 1];
            } else if (i + 1 >= n) {
                result[i] = dp1[i - 1];
            } else {
                result[i] = dp1[i - 1] * dp2[i + 1];
            }
        }

        return result;
    }
}
