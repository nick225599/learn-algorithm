package org.nick.learn.leetcode.p52;

public class P52Solution6 {
    // 自己尝试实现，基于位图和位运算的回溯
    // 0ms 击败 100%
    // 自己是死活也想不出来还能这么解，写代码就跟写作文一样，没有充沛的阅读量，写不出好的作文
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int column = 0; column < n; column++) {
            // 当前行是否可选？
            int availablePos = ~columns & ~diagonals1 & ~diagonals2;
            int insertPos = 1 << column;
            if((insertPos & availablePos) > 0){ // 可以写入
                count += solve(n, row + 1,
                        columns | insertPos,
                        (diagonals1 | insertPos) << 1,
                        (diagonals2 | insertPos) >> 1
                        ); // 甚至不需要撤回操作，计算下一行的 columns, diagonals1, diagonals2 也非常方便，
                // 不用像 P52Solution1 那样死活写不出来
            }
        }
        return count;
    }


}
