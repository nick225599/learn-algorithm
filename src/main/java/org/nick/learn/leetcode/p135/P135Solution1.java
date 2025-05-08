package org.nick.learn.leetcode.p135;

import org.nick.learn.leetcode.p238.P238Solution2;

public class P135Solution1 {

    /**
     * 两次遍历法
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * 可进一步优化降低空间复杂度，优化方案类似第 238 题
     * @see P238Solution2
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] l = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 1;
            }
        }


        int[] r = new int[n];
        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(l[i], r[i]);
        }
        return sum;
    }
}
