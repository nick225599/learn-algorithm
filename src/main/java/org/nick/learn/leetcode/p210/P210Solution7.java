package org.nick.learn.leetcode.p210;

import java.util.*;

public class P210Solution7 {

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/course-schedule-ii/solutions/249149/ke-cheng-biao-ii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        // 存储有向图
        List<List<Integer>> edges;
        // 存储每个节点的入度
        int[] indeg;
        // 存储答案
        int[] result;
        // 答案下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            // 将所有入度为 0 的节点放入队列中
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                // 从队首取出一个节点
                int u = queue.poll();
                // 放入答案中
                result[index++] = u;
                for (int v: edges.get(u)) {
                    --indeg[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }



}
