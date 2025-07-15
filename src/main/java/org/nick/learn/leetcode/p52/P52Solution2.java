package org.nick.learn.leetcode.p52;

//TODO nick 20250715 应该是判断列和两个斜线
public class P52Solution2 {
    int n;
    int result;

    int count;

    boolean[] queueRows; // 哪几行存在皇后
    boolean[] queueColumns; // 哪几列存在皇后

    int row; // 当前在第几行
    int column; // 当前在第几列
    boolean[] rowFlag; // 当前行哪几列被皇后影响


    // 785ms 击败6%
    public int totalNQueens(int n) {
        this.result = 0;
        this.count = 0;

        this.n = n;

        this.dfs(0);

        return result;
    }

    private void dfs(int index) {
        if (index >= n * n) {
            return;
        }

        int row = index / n;
        int column = index % n;

        // 不放
        this.dfs(index + 1);

        // 放
        // 从上一层的 rowFlag 计算出当前层
        this.rowFlag = nextFloor(rowFlag);
        this.count++;
        queueRows[row] = true;
        queueColumns[column] = true;


        this.dfs(index + 1);
    }

    private boolean[] nextFloor(boolean[] rowFlag) {
        boolean left = true;
        for (int i = 0; i < n; i++) {
            if (rowFlag[i]) {
                if (left) {
                    if (i - 1 >= 0) {
                        rowFlag[i - 1] = true;
                    }
                    rowFlag[i] = false;
                    left = false;
                } else {
                    if (i + 1 < n) {
                        rowFlag[i + 1] = true;
                    }
                    rowFlag[i] = false;
                }
            }

        }
        return null;
    }


}
