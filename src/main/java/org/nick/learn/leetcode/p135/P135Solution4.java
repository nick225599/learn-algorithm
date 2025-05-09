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
        int preNum = 1;
        int curNum;
        for (int i = 1; i < n; i++) {
            int preRate = ratings[i - 1];
            int curRate = ratings[i];
            if (preRate < curRate) {
                curNum = preNum + 1;
                sum += curNum;
                asc++;
                preNum = curNum;
            } else if (preRate > curRate) {
                curNum = 1;
                sum += curNum;
                desc++;
                preNum = curNum;
                if (asc == desc) {
                    desc++;
                    asc--;
                }
                sum += (desc - 1);
            } else {
                curNum = 1;
                sum += curNum;
                asc = 1;
                desc = 0;
                preNum = curNum;
            }
        }

        return sum;
    }
}
