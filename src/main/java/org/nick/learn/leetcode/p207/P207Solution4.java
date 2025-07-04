package org.nick.learn.leetcode.p207;

import java.util.*;

public class P207Solution4 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int prereq = prerequisite[1];
            if (cur == prereq) {
                return false;
            }
            List<Integer> ableList = graph.computeIfAbsent(prereq, k -> new ArrayList<>());
            ableList.add(cur);
        }

        for (Map.Entry<Integer, List<Integer>> entry1 : graph.entrySet()) {
            Integer key1 = entry1.getKey();
            List<Integer> values1 = entry1.getValue();
            // 已知 key1 -> key2
            for (Integer key2 : values1) {
                // 在图中找有没有 key2 -> key1 的路径
                if (this.pathExist(graph, key2, key1)) {
                    return false;
                }
            }
        }

        return true;

    }

    // bfs
    private boolean pathExist(Map<Integer, List<Integer>> graph, Integer start, Integer end) {

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        List<Integer> value = graph.get(start);
        if (value == null || value.isEmpty()) {
            return false;
        }

        // 在 value 以及 value 衍生 sub-value 中找 end
        Queue<List<Integer>> valueQueue = new LinkedList<>();
        valueQueue.add(value);

        while (true) {
            value = valueQueue.poll();
            if (value == null) {
                return false;
            }
            if (value.contains(end)) {
                return true;
            }
            for (Integer val : value) {
                if (graph.containsKey(val)) {
                    // 存在环
                    if (visited.contains(val)) {
                        return false;
                    } else {
                        valueQueue.add(graph.get(val));
                        visited.add(val);
                    }
                }
            }
        }
    }
}
