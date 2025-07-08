package org.nick.learn.leetcode.p909;

import java.util.LinkedList;
import java.util.Queue;

public class P909Solution2 {

    static class MoveStatus {
        public int cur;
        public int steps;

        public MoveStatus(int cur, int steps) {
            this.cur = cur;
            this.steps = steps;
        }
    }

    // 让 AI 优化一下，5ms
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int total = n * n;

        boolean[] visited = new boolean[total + 1];

        Queue<MoveStatus> queue = new LinkedList<>();
        queue.offer(new MoveStatus(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            MoveStatus cur = queue.poll();
            if (cur.cur == total) {
                return cur.steps;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur.cur + i;
                if (next > total) {
                    break;
                }
                int[] arr = index2coordinate(n, next);
                int x = arr[0];
                int y = arr[1];
                if (board[x][y] != -1) {
                    next = board[x][y];
                }
                if (!visited[next]) {
                    queue.add(new MoveStatus(next, cur.steps + 1));
                    visited[next] = true;
                }
            }
        }

        return -1;
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

//    private int[] index2coordinate(int n, int index) {
//        index--; // 转换为0-based索引
//        int row = n - 1 - (index / n);
//        int colBase = index % n;
//        int col = (n - 1 - row) % 2 == 0 ? colBase : n - 1 - colBase;
//        return new int[]{row, col};
//    }


}
