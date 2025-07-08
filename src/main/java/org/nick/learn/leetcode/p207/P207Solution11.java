package org.nick.learn.leetcode.p207;

public class P207Solution11 {

    static class Node {
        Node next;
        int val;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 1ms 方案
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] corses = new Node[numCourses];
        for (int[] pre : prerequisites) {
            corses[pre[0]] = new Node(pre[1], corses[pre[0]]);
        }
        boolean[] finished = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(corses, finished, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Node[] corses, boolean[] finished, boolean[] visited, int i) {
        if (finished[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        Node node = corses[i];
        while (node != null) {
            if (!dfs(corses, finished, visited, node.val))
                return false;
            node = node.next;
        }
        finished[i] = true;
        return true;
    }

}
