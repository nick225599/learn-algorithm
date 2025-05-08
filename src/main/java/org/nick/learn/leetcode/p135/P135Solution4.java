package org.nick.learn.leetcode.p135;

public class P135Solution4 {

    /**
     * 一次遍历法
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1;
        int asc = 1;
        int desc = 0;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                desc = 0;
                int cur = (ratings[i - 1] == ratings[i]) ? 1 : pre + 1;
                sum += cur;
                pre = cur;
//                asc++; // asc 不用 == 0？
                asc = cur; // 需要的，直接用 cur 的值赋值一下就行
            } else {
                desc++;
                if(desc == asc){
                    desc++; // asc 不用 -- ？
                    // 不用在 if(){} 中能够被正确地赋值为 1
                }
                sum += desc;
                pre = 1;
            }
        }

        return sum;
    }
}
