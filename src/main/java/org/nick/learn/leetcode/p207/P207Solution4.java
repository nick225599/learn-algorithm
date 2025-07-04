package org.nick.learn.leetcode.p207;

import java.util.*;

public class P207Solution4 {

    // AI 修复后的 bfs 版本的 path exist 方法
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表表示图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 记录每个节点的入度（即有多少前置课程）
        int[] inDegree = new int[numCourses];

        // 初始化图和入度数组
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            // 检查自环
            if (course == preCourse) return false;

            // 添加边：preCourse -> course
            graph.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(course);
            // 更新入度
            inDegree[course]++;
        }

        // 使用队列进行拓扑排序（BFS）
        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录已访问的节点数
        int visitedCount = 0;

        // 开始拓扑排序
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visitedCount++;

            // 遍历当前节点的所有后继节点
            List<Integer> neighbors = graph.getOrDefault(current, Collections.emptyList());
            for (int neighbor : neighbors) {
                // 减少后继节点的入度
                inDegree[neighbor]--;
                // 如果入度变为0，加入队列
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 如果所有节点都被访问过，说明没有环
        return visitedCount == numCourses;
    }
}
