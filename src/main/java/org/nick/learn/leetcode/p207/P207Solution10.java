package org.nick.learn.leetcode.p207;

import java.util.LinkedList;

public class P207Solution10 {
    private LinkedList<Integer>[] graph;
    //    private int[] visited;
    boolean[] visited;
    boolean[] visiting;
    private boolean invalid;

    // DFS = 改为延迟创建，也只能优化到 3ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new LinkedList[numCourses];

//        for (int i = 0; i < numCourses; i++) {
//            graph.add(new LinkedList<>());
//        }

        for (int[] arr : prerequisites) {
            // take course0 you have to first take course1
            int course0 = arr[0];
            int course1 = arr[1];
            if (graph[course0] == null) {
                graph[course0] = new LinkedList<>();
            }
            graph[course0].add(course1);
        }

        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses && !invalid; i++) {
            if (!visited[i]) {
                this.dfs(i);
            }
        }
        return !invalid;
    }

    private void dfs(int i) {
        if (visited[i]) {
            return;
        }
        if (visiting[i]) {
            invalid = true;
            return;
        }
        if (graph[i] == null) {
            visited[i] = true;
            return;
        }
        visiting[i] = true;
        for (int value : graph[i]) {
            this.dfs(value);
        }
        visited[i] = true;
    }
}
