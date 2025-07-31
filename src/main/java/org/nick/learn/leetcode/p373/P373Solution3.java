package org.nick.learn.leetcode.p373;

import java.util.*;

public class P373Solution3 {

    // 用 hashtable 来去重
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Set<String> used = new HashSet<>();
        priorityQueue.add(new int[]{nums1[0] + nums2[0], 0, 0});
        used.add(this.key(0, 0));

        List<List<Integer>> ans = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {

            int[] idx = priorityQueue.poll();
            int x = idx[1];
            int y = idx[2];

            List<Integer> pair = new ArrayList<>(2);
            pair.add(nums1[x]);
            pair.add(nums2[y]);
            ans.add(pair);

            if (x + 1 < n1) {
                String key = this.key(x + 1, y);
                if (!used.contains(key)) {
                    priorityQueue.add(new int[]{nums1[x + 1] + nums2[y], x + 1, y});
                    used.add(key);
                }
            }

            if (y + 1 < n2) {
                String key = this.key(x, y + 1);
                if (!used.contains(key)) {
                    priorityQueue.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
                    used.add(key);
                }
            }

        }

        return ans;
    }

    private String key(int x, int y) {
        return x + "," + y;
    }


}
