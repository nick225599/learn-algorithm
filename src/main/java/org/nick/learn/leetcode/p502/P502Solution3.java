package org.nick.learn.leetcode.p502;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P502Solution3 {

    // 仿写官方题解
    // 106ms 击败48%
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        Arrays.sort(projects, (p1, p2) -> p1[0] - p2[0]);

        PriorityQueue<Integer> capitalHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        for(int iK = 0; iK < k; iK++){

            while (i < n && projects[i][0] <= w) {
                capitalHeap.add(projects[i][1]);
                i++;
            }

            if (capitalHeap.isEmpty()) {
                break;
            }

            w += capitalHeap.poll();
        }

        return w;
    }

}
