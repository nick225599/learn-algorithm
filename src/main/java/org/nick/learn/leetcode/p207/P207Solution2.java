package org.nick.learn.leetcode.p207;

import java.util.*;

public class P207Solution2 {


    // 尝试失败，监测不出两链或三链的环
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 无语......
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            Set<Integer> distSet = graph.computeIfAbsent(pre, k -> new HashSet<>());
            distSet.add(cur);
        }

        // 监测环
        List<Integer> remove = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int key = entry.getKey();
            Set<Integer> value = entry.getValue();
            for (Map.Entry<Integer, Set<Integer>> entry2 : graph.entrySet()) {
                int key2 = entry2.getKey();
                Set<Integer> value2 = entry2.getValue();

                if (key == key2) {
                    continue;
                }
                if (value.contains(key2) && value2.contains(key)) {
                    remove.add(key);
                    remove.add(key2);
                }
            }
        }
        for (Integer key : remove) {
            graph.remove(key);
        }

        if (graph.size() == 1) {
            return true;
        }

        if (graph.size() >= numCourses) {
            return true;
        }

        int total = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int key = entry.getKey();
            total += 1;
            Set<Integer> value = entry.getValue();
            total += value.size();
            if (total >= numCourses) {
                return true;
            }
        }


        // 能用邻接表来处理 prerequisites 但怎么解题？
        return false;

    }
}
