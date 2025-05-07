package org.nick.learn.leetcode.p274;

/**
 * 力扣 274. H 指数
 * @see <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">力扣 274. H 指数</a>
 */
public class P274Solution3 {

        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] counter = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (citations[i] >= n) {
                    counter[n]++;
                } else {
                    counter[citations[i]]++;
                }
            }

            // 计数排序之后得到的数组是 [2, 0, 1, 0]
            int total = 0;
            for (int i = n; i >= 0; i--) {
                total += counter[i];
                if (total >= i) {
                    return i;
                }
            }
            return 0;
        }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/h-index/solutions/869042/h-zhi-shu-by-leetcode-solution-fnhl/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
