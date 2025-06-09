package org.nick.learn.leetcode.p56;

import java.util.Arrays;

public class P56Solution2 {

    // 有啥好的解法???
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (needMerge(intervals, i, j)) {
                    merge(intervals, i, j);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (needMerge(intervals, i, j)) {
                    merge(intervals, i, j);
                }
            }
        }


        return Arrays.stream(intervals)
                .filter(ints -> ints[0] != -1)
                .toArray(int[][]::new); // 使用 int[][]::new 作为数组构造器
    }

    private boolean needMerge(int[][] intervals, int i, int j) {
        if (intervals[i][0] == -1 || intervals[j][0] == -1) {
            return false;
        }
        //     []
        // []
        if (intervals[j][1] < intervals[i][0]) {
            return false;
        }
        // []
        //     []
        if (intervals[i][1] < intervals[j][1]) {
            return false;
        }
        return true;
    }

    private void merge(int[][] intervals, int i, int j) {
        intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
        intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);

        intervals[i][0] = intervals[i][1] = -1;
    }
}
