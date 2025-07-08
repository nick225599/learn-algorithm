package org.nick.learn.leetcode.p909;

public class P909Solution6 {

    // DFS

    // 909 题能用 DFS 解题吗？
    // 是的，理论上可以用 DFS（深度优先搜索）解决蛇梯棋问题，但实际实现时会遇到严重的效率问题。主要原因是：
    //
    // 最短路径问题：BFS 天然适合寻找无权图的最短路径，因为它逐层扩展，首次到达终点时路径必然最短。
    // 而 DFS 可能会陷入深层路径，需要遍历所有可能路径才能确定最短路径。

    // 循环路径：蛇梯棋中可能存在循环（例如梯子和蛇形成闭环），
    // DFS 需要额外机制避免无限递归，
    // 而 BFS 可以通过 visited 数组简单解决。
    private int minSteps = Integer.MAX_VALUE;
    private int n;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        dfs(board, 1, 0, visited);
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    private void dfs(int[][] board, int pos, int steps, boolean[] visited) {
        // 到达终点，更新最小步数
        if (pos == n * n) {
            minSteps = Math.min(minSteps, steps);
            return;
        }

        // 剪枝：当前步数已超过已知最小步数
        if (steps >= minSteps) return;

        // 处理6种掷骰子可能
        for (int i = 1; i <= 6; i++) {
            int nextPos = pos + i;
            if (nextPos > n * n) break;

            // 计算坐标并检查梯子/蛇
            int[] coord = getCoord(nextPos);
            int row = coord[0], col = coord[1];
            if (board[row][col] != -1) {
                nextPos = board[row][col];
            }

            // 避免循环：如果下一步已在当前路径中，跳过
            if (visited[nextPos]) continue;

            // 递归搜索
            visited[nextPos] = true;
            dfs(board, nextPos, steps + 1, visited);
            visited[nextPos] = false; // 回溯
        }
    }

    private int[] getCoord(int id) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
