package org.nick.learn.leetcode.p79;


public class P79Solution5 {

    char[][] board;
    int w;
    int h;

    String word;

    boolean[][] used;

    // 参考民间解题方案进行一下优化
    public boolean exist(char[][] board, String word) {


        this.board = board;
        this.h = board.length;
        this.w = board[0].length;

        // ---- 尽可能提前判断 false 的情况 START ----
        // 提前判断可以在以下情况避免 DFS 的指数级搜索：
        // 虽然不改变最坏情况的复杂度，但能有效改善平均情况的性能。
        // 1. 单词长度超过网格大小：直接返回 false。
        if(word.length() > h * w){
            return false;
        }
        // 2. 单词中某个字符的频率超过网格中的可用次数：在遍历单词的过程中一旦发现立即返回 false。
        int[] bCount = new int[255];
        int[] wCount = new int[255];
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                char i = board[r][c];
                bCount[i]++;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wCount[c]++;
            if (wCount[c] > bCount[c]) {
                return false;
            }
        }
        // ---- 尽可能提前判断 false 的情况 END ----



        this.used = new boolean[h][w];
        this.word = word;

        // 这个翻转有什么用？
        // 优化原理
        // 在 DFS 搜索中，起始字符的选择会显著影响搜索效率。
        // 如果从一个出现次数较多的字符开始搜索，
        // DFS 可能会产生更多的分支（因为有更多的起始位置），导致搜索空间迅速扩大。
        // 反之，从出现次数较少的字符开始搜索，可以减少初始分支数量，从而降低整体搜索复杂度。

        // 如果从高频字符开始，早期分支多，可能导致大量路径在较深的层级才被剪枝（例如，前 5 个字符都匹配，但第 6 个不匹配）。
        // 而从低频字符开始，早期分支少，更多无效路径会在浅层被快速剪枝。
        char wordFirstChar =word.charAt(0);
        char wordLastChar = word.charAt(word.length() - 1);
        if(wCount[wordFirstChar] > wCount[wordLastChar]){
            this.word = new StringBuilder(word).reverse().toString();
        }

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
        if ((r - 1 >= 0 && !used[r - 1][c] && dfs(r - 1, c, i + 1))
                || (r + 1 < h && !used[r + 1][c] && dfs(r + 1, c, i + 1))
                || (c - 1 >= 0 && !used[r][c - 1] && dfs(r, c - 1, i + 1))
                || (c + 1 < w && !used[r][c + 1] && dfs(r, c + 1, i + 1))) {
            return true;
        }

        // 解除标记
        used[r][c] = false;

        return false;
    }


}
