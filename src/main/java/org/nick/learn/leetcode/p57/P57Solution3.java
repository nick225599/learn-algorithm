package org.nick.learn.leetcode.p57;

import java.util.ArrayList;
import java.util.List;

public class P57Solution3 {

    // 怎么进一步降低常数因子？
    // 插入和合并放到一个循环中处理
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>(n + 1);
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                if (newInterval[0] < interval[0]) {
                    res.add(newInterval);
                    inserted = true;
                    int[] lastInterval = res.getLast();
                    if (lastInterval[1] < interval[0]) {
                        res.add(interval);
                    } else {
                        lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                    }
                } else {
                    res.add(interval);
                }
                continue;
            }

            if (!inserted && interval[0] >= newInterval[0]) {
                int[] lastInterval = res.getLast();
                if (lastInterval[1] < newInterval[0]) {
                    res.add(newInterval);
                } else {
                    lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
                }
                inserted = true;
            }

            int[] lastInterval = res.getLast();
            if (lastInterval[1] < interval[0]) {
                res.add(interval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        // 如果新数组没插入过，插入新数组
        if (!inserted) {
            int[] lastInterval = res.getLast();
            if (lastInterval[1] < newInterval[0]) {
                res.add(newInterval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
            }
        }


        return res.toArray(int[][]::new);
    }
}
