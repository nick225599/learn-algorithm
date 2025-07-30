package org.nick.learn.leetcode.p373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P373Solution1 {

    // 超出内存限制
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                pq1.add(new int[]{i1 + i2, i1, i2});
            }
        }

        List<List<Integer>> ans = new ArrayList<>(k);
        List<Integer> pair;
        for(int i = 0; i < k; i++){
            int[] arr = pq1.poll();

            pair = new ArrayList<>(2);
            pair.add(arr[1]);
            pair.add(arr[2]);

            ans.add(pair);
        }
        return ans;
    }
}
