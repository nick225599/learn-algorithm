package org.nick.learn.leetcode.p373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P373Solution4 {

    // 用技巧来去重，这个技巧是真的难理解
    // 32ms 击败51%
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < Math.min(k, n1); i++) {
            priorityQueue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        List<List<Integer>> ans = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {

            int[] idx = priorityQueue.poll();
            int x = idx[1];
            int y = idx[2];

            List<Integer> pair = new ArrayList<>(2);
            pair.add(nums1[x]);
            pair.add(nums2[y]);
            ans.add(pair);

            if (y + 1 < n2) {
                priorityQueue.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
            }

        }

        return ans;
    }


}
