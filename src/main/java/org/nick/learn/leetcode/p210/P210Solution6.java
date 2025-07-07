package org.nick.learn.leetcode.p210;

import java.util.*;

public class P210Solution6 {

    private int index = 0;

    // 临接表 + Kahn 算法
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            // you must take course b first if you want to take course a.
            // a 依赖于 b
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph.get(b).add(a);
            degree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int i = queue.remove();
            result[index++] = i; // 贪心算法，采用局部最优解就可以推出全局最优解
            for(int j : graph.get(i)){
                degree[j]--;
                if (degree[j] == 0) {
                    queue.add(j);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;

    }


}
