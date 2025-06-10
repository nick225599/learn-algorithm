package org.nick.learn.leetcode.p452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P452Solution1 {
    // 时间复杂度 O(nlogn)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] point : points){
             if(result.isEmpty()){
                 result.add(point);
                 continue;
             }
            if (result.getLast()[1] < point[0]) {
                result.add(point);
            } else {
                result.getLast()[0] = Math.max(result.getLast()[0], point[0]);
                result.getLast()[1] = Math.min(result.getLast()[1], point[1]);
            }
        }
        return result.size();
    }
}
