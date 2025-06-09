package org.nick.learn.leetcode.p56;

import java.util.HashMap;
import java.util.Map;

public class P56Solution1 {

    // 时间复杂度 O(n^2)
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }
        boolean merged;
        do {
            merged = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int startOfI = intervals[i][0];
                    int endOfI = intervals[i][1];
                    int startOfJ = intervals[j][0];
                    int endOfJ = intervals[j][1];

                    if(startOfI == startOfJ && endOfI == endOfJ){
                        continue;
                    }

                    if (endOfI < startOfJ || endOfJ < startOfI) {
                        continue;
                    }

                    int start = Math.min(startOfI, startOfJ);
                    int end = Math.max(endOfI, endOfJ);
                    intervals[i][0] = start;
                    intervals[i][1] = end;
                    intervals[j][0] = start;
                    intervals[j][1] = end;

                    merged = true;
                }
            }
        } while (merged);


        Map<String, int[]> map = new HashMap<>();
        for (int[] arr : intervals) {
            String hash = hash(arr);
            map.put(hash, arr);
        }
        int m = map.size();
        int[][] result = new int[m][];
        int i = 0;
        for (int[] value : map.values()) {
            result[i++] = value;
        }
        return result;
    }

    private String hash(int[] arr) {
        return arr[0] + "," + arr[1];
    }

}
