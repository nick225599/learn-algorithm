package org.nick.learn.leetcode.p502;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P502Solution2 {

    //    作者：力扣官方题解
    //    链接：https://leetcode.cn/problems/ipo/solutions/984750/ipo-by-leetcode-solution-89zm/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;

        // 这里的 arr 承担了 Solution1 的 buff 的角色，这样 buff 也不需要无用地 clear 了
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {

            // 限制大顶堆的写入，这样就不需要进行无用地取和塞入了
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }


}
