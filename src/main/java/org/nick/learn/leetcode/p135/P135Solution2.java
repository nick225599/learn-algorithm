package org.nick.learn.leetcode.p135;

public class P135Solution2 {

    /**
     * 一次遍历法
     *
     * //TODO nick 20250508 有报错，看下官方题解
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1;
        int pre = 1;
        int ascLength = 1;
        int descLength = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                int cur = pre + 1;
                sum += cur;
                ascLength++;
                descLength = 0;
                pre = cur;
            } else if (ratings[i - 1] == ratings[i]) {
                int cur = 1;
                sum += cur;
                ascLength = 1;
                descLength = 0;
                pre = cur;
            } else {
                int cur = pre - 1;
                if (cur >= 1) {
                    sum += cur;
                    descLength += 1;
                    pre = cur;
                } else {
                    cur = 1;
                    sum += cur;
                    sum += descLength;
                    descLength++;
                    if(ascLength == descLength){
                        sum +=1;
                        ascLength--;
                        descLength++;
                    }
                }
            }
        }


        return sum;
    }
}
