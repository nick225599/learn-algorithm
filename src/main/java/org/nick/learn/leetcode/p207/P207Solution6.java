package org.nick.learn.leetcode.p207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207Solution6 {


    // BFS
    // 8ms，击败 24.79%
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] arr : prerequisites) {
            // to take course0 you have to first take course1.
            int course0 = arr[0];
            int course1 = arr[1];
            graph.get(course1).add(course0);
            degree[course0]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }


        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int i = queue.poll();
            // graph.get(i): 学了课程 i 之后可以学的其他课程
            for (int value : graph.get(i)) {
                degree[value]--;
                if (degree[value] == 0) {
                    queue.offer(value);
                }
            }
        }

        return count == numCourses;
    }
}
