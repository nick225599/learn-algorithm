package org.nick.learn.leetcode.p207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P207Solution8 {

    private List<List<Integer>> graph;
    private int[] visited;
    private boolean invalid;

    // DFS 6ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] arr : prerequisites) {
            // take course0 you have to first take course1
            int course0 = arr[0];
            int course1 = arr[1];
            graph.get(course0).add(course1);
        }

        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                this.dfs(i);
            }
            if (invalid) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i) {
        if (visited[i] == 2) {
            return;
        }
        visited[i] = 1;
        for (int value : graph.get(i)) {
            if(visited[value] == 1){
                invalid = true;
                return;
            }
            dfs(value);
        }
        visited[i] = 2;
    }

}


