package org.nick.learn.leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56Solution4 {

    // 有啥好的解法???
    // 排序后合并
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i < n; i++){
            if(merged.getLast()[1] < intervals[i][0]){
                merged.add(intervals[i]);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            }
        }

        return merged.toArray(int[][]::new);
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
        if (intervals[i][1] < intervals[j][0]) {
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
