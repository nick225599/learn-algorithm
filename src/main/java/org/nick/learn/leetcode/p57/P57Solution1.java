package org.nick.learn.leetcode.p57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P57Solution1 {

    // 时间复杂度O(nlogn)， 排序
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> intervalsList = new ArrayList<>(n + 1);
        Collections.addAll(intervalsList, intervals);
        intervalsList.add(newInterval);
        intervalsList.sort(Comparator.comparingInt(arr -> arr[0]));

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
