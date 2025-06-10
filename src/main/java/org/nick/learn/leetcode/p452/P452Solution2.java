package org.nick.learn.leetcode.p452;

import java.util.Arrays;
import java.util.Comparator;

public class P452Solution2 {
    // 时间复杂度 O(nlogn)
    // 只需要计数就行，不用 List<int[]> res
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int right = points[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int[] point = points[i];
            if (right < point[0]) {
                right = point[1];
                count++;
            } else {
                right = Math.min(right, point[1]);
            }
        }
        return count;
    }
}
