package org.nick.learn.leetcode.p210;

public class P210Solution1 {

    private int index = 0;

    // dfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            // you must take course b first if you want to take course a.
            // a 依赖 b
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph[a][b] = true;
        }

        boolean[] visited = new boolean[numCourses];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result = dfs(graph, visited, result, i);
        }
        return result;
    }

    private int[] dfs(boolean[][] graph, boolean[] visited, int[] result, int value) {
        if (visited[value]) {
            return new int[0];
        } else {
            visited[value] = true;
        }
        for (int i = 0; i < graph.length; i++) {
            // 如果 value 依赖其他值，则需要先处理其他值
            if (graph[value][i]) {
                this.dfs(graph, visited, result, i);
            }
        }
        result[index++] = value;
        return result;
    }
}
