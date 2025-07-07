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
        int[] visiteStatus = new int[numCourses]; // 0 未访问过，1 遍历中，2 遍历完成
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            try {
                this.dfs(graph, visiteStatus, result, i);
            } catch (IllegalArgumentException e) {
                return new int[0];
            }
        }
        return result;
    }

    private void dfs(boolean[][] graph, int[] visiteStatus, int[] result, int value) {
        if (visiteStatus[value] == 3) {
            return;
        } else {
            visiteStatus[value] = 1;
        }
        for (int i = 0; i < graph.length; i++) {
            // 如果 value 依赖其他值，则需要先处理其他值
            if (graph[value][i]) {
                if (visiteStatus[i] == 1) {
                    throw new IllegalArgumentException("cycle");
                }
                this.dfs(graph, visiteStatus, result, i);
            }
        }
        result[index++] = value;
        visiteStatus[value] = 3;
    }
}
