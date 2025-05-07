package org.nick.learn.leetcode.p274;

/**
 * 力扣 274. H 指数
 * @see <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">力扣 274. H 指数</a>
 */
public class P274Solution4 {

    /**
     * 计数排序
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] buff = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                buff[n]++;
            } else {
                buff[citation]++;
            }
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buff[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
