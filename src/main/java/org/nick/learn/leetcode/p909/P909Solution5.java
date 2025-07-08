package org.nick.learn.leetcode.p909;

public class P909Solution5 {

    // 1ms 版本
    // 通过数组维护含分层信息的队列，精简代码，避免使用 jdk 自身功能复杂的 Queue
    public int snakesAndLadders(int[][] board) {
        int n = board.length, target = n * n, ans = 0, top = 0, rear = 1, size = 1;
        boolean[] visit = new boolean[target];
        int[] queue = new int[target];
        visit[0] = true;
        while (size > 0) {
            ans++;
            while (size > 0) {
                size--;
                int cur = queue[top++];
                for (int i = 1; i < 7; i++) {
                    int next = cur + i;
                    if (next >= target - 1) return ans;
                    if (visit[next]) continue;
                    visit[next] = true;
                    int row = next / n, col = next % n;
                    if (row % 2 == 1) col = n - 1 - col;
                    row = n - 1 - row;
                    if (board[row][col] == -1) {
                        queue[rear++] = next;
                    } else {
                        next = board[row][col] - 1;
                        if (next == target - 1) return ans;
                        queue[rear++] = next;
                    }
                }
            }
            size = rear - top;
        }
        return -1;
    }
}
