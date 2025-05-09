package org.nick.learn.leetcode.p135;

public class P135Solution4 {

    /**
     * 一次遍历法
     *
     * 时间复杂度O(n)
     *
     * asc 的维护太麻烦了，升序和降序的边界变化的场景过多容易出错，不如左右两次遍历法好维护
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1;
        int asc = 1;
        int desc = 0;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                pre++;
                sum += pre;
                asc = pre;
                desc = 0;
            } else if (ratings[i] < ratings[i - 1]) {
                desc++;
                sum += desc;
                pre = 1;
                if (asc == desc) {
                    sum += 1;
                    desc++;
                }
            } else {
                pre = 1;
                sum += 1;
                asc = 1;
                desc = 0;
            }
        }

        return sum;
    }
}
