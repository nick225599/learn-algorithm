package org.nick.learn.leetcode.p207;

import java.util.*;

public class P207Solution2 {



    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            Set<Integer> distSet = graph.computeIfAbsent(pre, k -> new HashSet<>());
            distSet.add(cur);
        }

        if(graph.size() >= numCourses){
            return true;
        }


        // 能用邻接表来处理 prerequisites 但怎么解题？


        return false;

    }
}
