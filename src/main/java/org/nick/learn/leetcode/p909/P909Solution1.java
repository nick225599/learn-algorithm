package org.nick.learn.leetcode.p909;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P909Solution1 {

    static class MoveStatus {
        public int cur;
        public int steps;

        public MoveStatus(int cur, int steps) {
            this.cur = cur;
            this.steps = steps;
        }
    }

    // 求图的两点之间的最短路径
    // 能不能回溯处理？
    public int snakesAndLadders(int[][] board) {
        int widthOfBoard = board.length;
        int n = widthOfBoard * widthOfBoard;

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                int next = i + j;
                if(next > n){
                    continue;
                }
                int[] arr = index2coordinate(widthOfBoard, next);
                int x = arr[0];
                int y = arr[1];
                int value = board[x][y];
                if (value == -1) {
                    graph[i].add(next);
                } else {
                    graph[i].add(value);
                }
            }
        }

        Queue<MoveStatus> queue = new LinkedList<>();
        queue.offer(new MoveStatus(1, 0));

        int minSteps = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            MoveStatus cur = queue.poll();
            visited[cur.cur] = true;
            if (cur.cur == n) {
                minSteps = Math.min(minSteps, cur.steps);
            } else {
                for (int next : graph[cur.cur]) {
                    if (!visited[next]) {
                        queue.add(new MoveStatus(next, cur.steps + 1));
                    }
                }
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;


    }



    private int[] index2coordinate(int widthOfBoard, int index) {
        index--;

        int a, b; // index = n * a + b
        a = index / widthOfBoard;
        b = index - a * widthOfBoard;

        int row, column;
        row = widthOfBoard - 1 - a;
        if ((widthOfBoard - 1 - row) % 2 == 0) {
            column = b;
        } else {
            column = widthOfBoard - 1 - b;
        }
        return new int[]{row, column};
    }




}
