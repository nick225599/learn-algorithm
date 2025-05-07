package org.nick.learn.leetcode.p274;

/**
 * 力扣 274. H 指数
 * @see <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">力扣 274. H 指数</a>
 */
public class P274Solution2 {

    /**
     * 计数排序
     *
     * nick 20250507 有 BUG 看下官方题解怎么处理计数排序的结果的
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int referenceTimes : citations) {
            if (referenceTimes >= n) {
                counter[n]++;
            } else {
                counter[referenceTimes]++;
            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += counter[counter.length - i];
            if(sum >= i){
                continue;
            }else{
                return i -1;
            }
        }
        return n;
    }
}
