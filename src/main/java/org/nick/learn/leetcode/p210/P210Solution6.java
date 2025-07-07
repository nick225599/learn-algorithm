package org.nick.learn.leetcode.p210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P210Solution6 {

    private int index = 0;

    // 临接表 + Kahn 算法
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>(numCourses));
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

        Queue<Integer> queue = new ArrayDeque<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int i = queue.remove();
            result[index++] = i;
            this.kahn(graph, i, degree, queue);
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;

    }

    private void kahn(List<List<Integer>> graph , int value, int[] degree, Queue<Integer> queue) {
        for(int i : graph.get(value)){
            degree[i]--;
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
    }

}
