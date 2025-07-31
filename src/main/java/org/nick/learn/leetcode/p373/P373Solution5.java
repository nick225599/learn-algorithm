package org.nick.learn.leetcode.p373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P373Solution5 {

    // 民间 top0 解法
    // 16ms 击败99%
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int left = nums1[0] + nums2[0], right = nums1[n - 1] + nums2[m - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(nums1, nums2, n, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int u : nums1) {
            if (u + nums2[0] >= left)
                break;
            for (int v : nums2) {
                if (u + v < left)
                    ans.add(Arrays.asList(u, v));
                else
                    break;
            }
        }
        for (int u : nums1) {
            if (u + nums2[m - 1] < left)
                continue;
            for (int v : nums2) {
                if (u + v == left) {
                    ans.add(Arrays.asList(u, v));
                    if (ans.size() == k)
                        return ans;
                } else if (u + v > left) {
                    break;
                }
            }
        }
        return null;
    }

    public boolean check(int[] nums1, int[] nums2, int n, int m, int k, int num) {
        int i = 0, j = m - 1;
        int cnt = 0;
        while (i < n && j >= 0) {
            if (nums1[i] + nums2[j] <= num) {
                cnt += j + 1;
                if (cnt >= k)
                    return true;
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}