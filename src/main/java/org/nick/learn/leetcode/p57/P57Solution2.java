package org.nick.learn.leetcode.p57;

import java.util.ArrayList;
import java.util.List;

public class P57Solution2 {

    // 时间复杂度O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> intervalsList = new ArrayList<>(n + 1);
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (!inserted && interval[0] >= newInterval[0]) {
                intervalsList.add(newInterval);
                inserted = true;
            }
            intervalsList.add(interval);
        }
        if(!inserted){
            intervalsList.add(newInterval);
        }

        List<int[]> res = new ArrayList<>();
        for (int[] curInterval : intervalsList) {
            if (res.isEmpty()) {
                res.add(curInterval);
                continue;
            }

            int[] lastInterval = res.getLast();
            if (lastInterval[1] < curInterval[0]) {
                res.add(curInterval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            }
        }
        return res.toArray(int[][]::new);
    }
}
