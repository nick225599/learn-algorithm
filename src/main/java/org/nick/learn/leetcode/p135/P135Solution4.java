package org.nick.learn.leetcode.p135;

public class P135Solution4 {

    /**
     * 一次遍历法
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int ret = 1;
        int asc = 1;
        int dec = 0;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                int cur = (ratings[i - 1] == ratings[i]) ? 1 : pre + 1;
                ret += cur;
                asc++;
                pre = cur;
            } else {
                dec++;
                if(dec == asc){
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }

        return ret;
    }
}
