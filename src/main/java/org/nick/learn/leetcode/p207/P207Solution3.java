package org.nick.learn.leetcode.p207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P207Solution3 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int prereq = prerequisite[1];
            List<Integer> ableList = graph.computeIfAbsent(prereq, k -> new ArrayList<>());
            ableList.add(cur);
        }

        for (Map.Entry<Integer, List<Integer>> entry1 : graph.entrySet()) {
            Integer key1 = entry1.getKey();
            List<Integer> values1 = entry1.getValue();
            // 已知 key1 -> key2
            for (Integer key2 : values1) {
                // 在图中找有没有 key2 -> key1 的路径
                if (this.bfs(graph, key2, key1)) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean bfs(Map<Integer, List<Integer>> graph, Integer start, Integer end) {

        return false;
    }
}
