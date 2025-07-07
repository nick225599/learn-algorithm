package org.nick.learn.leetcode.p210;

import java.util.ArrayDeque;
import java.util.Queue;

public class P210Solution5 {

    private int index = 0;

    // 临接矩阵 + Kahn 算法
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            // you must take course b first if you want to take course a.
            // a 依赖于 b
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph[a][b] = true;

            degree[a]++;
        }

        Queue<Integer> queue = new ArrayDeque<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        if(queue.isEmpty()){
            return new int[0];
        }

        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int i = queue.remove();
            result[index++] = i;
            this.kahn(result, graph, i, degree, queue);
        }

        if(index != numCourses){
            return new int[0];
        }

        return result;

    }

    private void kahn(int[] result, boolean[][] graph, int value, int[] degree, Queue<Integer> queue) {
        for (int i = 0; i < result.length; i++) {
            // 如果有 i 依赖于 value ， 那么 i 的入度 - 1
            if (graph[i][value]) {
                degree[i]--;
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }

}
