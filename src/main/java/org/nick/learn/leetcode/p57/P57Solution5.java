package org.nick.learn.leetcode.p57;

import java.util.ArrayList;
import java.util.List;

public class P57Solution5 {

    // 也挺啰嗦的，不过解法比较清晰
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0]; // 1
        int right = newInterval[1]; // 5
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (interval[1] < left) { // 当前区间在插入区间左侧
                res.add(interval);
            } else if (right < interval[0]) { // 当前区间在插入区间右侧
                if (!inserted) {
                    res.add(new int[]{left, right});
                    inserted = true;
                }
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!inserted) {
            res.add(new int[]{left, right});
        }
        return res.toArray(int[][]::new);
    }
}
