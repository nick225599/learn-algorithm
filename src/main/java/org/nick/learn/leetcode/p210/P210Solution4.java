package org.nick.learn.leetcode.p210;

import java.util.ArrayList;
import java.util.List;

public class P210Solution4 {

    private int index = 0;
    private boolean invalid = false;

    // dfs
    // 换邻接表试试
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            // you must take course b first if you want to take course a.
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph[a].add(b);
        }
        int[] visiteStatus = new int[numCourses]; // 0 未访问过，1 遍历中，2 遍历完成
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            this.dfs(graph, visiteStatus, result, i);
            if (invalid) {
                return new int[0];
            }
        }
        return result;
    }

    private void dfs(List<Integer>[] graph, int[] visiteStatus, int[] result, int value) {
        if (visiteStatus[value] == 2) {
            return;
        }
        if (visiteStatus[value] == 1) {
            invalid = true;
            return;
        }
        visiteStatus[value] = 1;

        // 比临接矩阵的性能高，邻接矩阵及时没有依赖关系，也需要进行一次 for 循环，每次 dfs() 的执行时间复杂度固定为 O(n)
        // 而临接表，均摊复杂度为 O(1)，每个顶点只会被遍历一次
        for (int i : graph[value]) {
            this.dfs(graph, visiteStatus, result, i);
        }
        result[index++] = value;
        visiteStatus[value] = 2;
    }
}
