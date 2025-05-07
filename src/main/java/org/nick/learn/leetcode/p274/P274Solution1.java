package org.nick.learn.leetcode.p274;

import java.util.Arrays;

/**
 * 力扣 274. H 指数
 * @see <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">力扣 274. H 指数</a>
 */
public class P274Solution1 {

    /**
     * 排序后遍历
     * TODO nick 双轴快排，堆排序怎么实现的，都快忘干净了......
     * O(nlogn)
     * O(1)
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 1; i <= n; i++) {
            int val = citations[n - i];
            if (val < i) {
                return i - 1;
            }
        }
        return n;
    }
}
