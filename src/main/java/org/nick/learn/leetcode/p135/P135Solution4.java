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

                //TODO nick 20250508 这段为啥这么写不对？
//                if (ratings[i - 1] < ratings[i]) {
//                    asc++;
//                } else {
//                    asc = 1;
//                }
                asc = cur;
            } else {
                desc++;
                if (desc == asc) {
                    desc++;
                    // asc--; // TODO NICK 20250508 这段为啥没必要？
                }
                sum += desc;
                pre = 1;
            }
        }

        return sum;
    }
}
