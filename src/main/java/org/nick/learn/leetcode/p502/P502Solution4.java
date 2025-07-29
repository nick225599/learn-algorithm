package org.nick.learn.leetcode.p502;

import java.util.PriorityQueue;

public class P502Solution4 {

    // 仿写民间最优解 贪心算法 + 双堆题解
    // 60ms 击败 98%
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<int[]> canDoHeap = new PriorityQueue<>((p1, p2) -> p2[1] - p1[1]);
        PriorityQueue<int[]> cannotDoHeap = new PriorityQueue<>((p1, p2) -> p1[0] - p2[0]);

        for (int i = 0; i < n; i++) {
            int[] project = new int[]{capital[i], profits[i]};
            if (project[0] <= w) {
                canDoHeap.add(project);
            } else {
                cannotDoHeap.add(project);
            }
        }

        for (int i = 0; i < k && !canDoHeap.isEmpty(); i++) {
            w += canDoHeap.poll()[1];

            while (!cannotDoHeap.isEmpty() && cannotDoHeap.peek()[0] <= w) {
                int[] project = cannotDoHeap.poll();
                canDoHeap.add(project);
            }
        }

        return w;
    }


}
