package org.nick.learn.leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56Solution3 {

    // 真简洁
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
