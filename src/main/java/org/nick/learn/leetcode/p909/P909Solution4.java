package org.nick.learn.leetcode.p909;

import java.util.LinkedList;
import java.util.Queue;

public class P909Solution4 {


    // 根据官方题解来，还是 5ms
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int total = n * n;

        boolean[] visited = new boolean[total + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > total) {
                    break;
                }
//                int[] arr = index2coordinate1(n, next); // 5ms
//                int[] arr = index2coordinate2(n, next); // 5ms
//                int[] arr = index2coordinate3(n, next); // 5ms
                int[] arr = index2coordinate4(n, next); // 5ms
                int x = arr[0];
                int y = arr[1];
                if (board[x][y] != -1) {
                    next = board[x][y];
                }
                // 提前 return 能把时间从 5ms 提升到 4ms
                if (next == total) {
                    return cur[1] + 1;
                }
                if (!visited[next]) {
                    queue.add(new int[]{next,cur[1] + 1 });
                    visited[next] = true;
                }
            }
        }

        return -1;
    }

    private int[] index2coordinate1(int n, int index) {
        index--;

        int a, b; // index = n * a + b
        a = index / n;
        b = index - a * n;

        int row, column;
        row = n - 1 - a;
        if ((n - 1 - row) % 2 == 0) {
            column = b;
        } else {
            column = n - 1 - b;
        }
        return new int[]{row, column};
    }

    private int[] index2coordinate2(int n, int index) {
        index--; // 转换为0-based索引
        int row = n - 1 - (index / n);
        int colBase = index % n;
        int col = (n - 1 - row) % 2 == 0 ? colBase : n - 1 - colBase;
        return new int[]{row, col};
    }

    private int[] index2coordinate3(int n, int index) {
        index--;
        int r = index / n;
        int row = n - 1 - r;
        int column = index % n;
        if(r % 2 == 1){
            column = n - 1 - column;
        }
        return new int[]{row, column};
    }

    private int[] index2coordinate4(int n, int id) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
