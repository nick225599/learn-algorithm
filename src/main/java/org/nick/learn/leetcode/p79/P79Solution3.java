package org.nick.learn.leetcode.p79;


public class P79Solution3 {

    char[][] board;
    int w;
    int h;

    String word;

    boolean[][] used;

    // 用 boolean[][] 重新写一次
    // 128ms 击败 78%
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.h = board.length;
        this.w = board[0].length;

        this.used = new boolean[h][w];
        this.word = word;

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (this.dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i) {
        if (board[r][c] != word.charAt(i)) {
            return false;
        } else if (i == word.length() - 1) {
            return true;
        }

        // 标记
        used[r][c] = true;

        // 递归
        boolean b = (r - 1 >= 0 && !used[r - 1][c] && dfs(r - 1, c, i + 1))
                || (r + 1 < h && !used[r + 1][c] && dfs(r + 1, c, i + 1))
                || (c - 1 >= 0 && !used[r][c - 1] && dfs(r, c - 1, i + 1))
                || (c + 1 < w && !used[r][c + 1] && dfs(r, c + 1, i + 1));

        // 解除标记
        used[r][c] = false;

        return b;
    }


}
