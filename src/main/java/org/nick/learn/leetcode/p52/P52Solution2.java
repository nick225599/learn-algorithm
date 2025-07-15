package org.nick.learn.leetcode.p52;

//TODO nick 20250715 应该是判断列和两个斜线
public class P52Solution2 {
    int n;
    int result;
    int count;

    boolean[] forbiddenColumns;
    boolean[] forbiddenLeft;
    boolean[] forbiddenRight;

    // 785ms 击败6%
    public int totalNQueens(int n) {
        this.n = n;
        this.result = 0;
        this.count = 0;
        forbiddenColumns = new boolean[n];
        forbiddenLeft = new boolean[n];
        forbiddenRight = new boolean[n];
        this.dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (index >= n * n) {
            return;
        }

        if (count == n) {
            result++;
            return;
        }

        int column = index % n;



        // 放
        if (!forbiddenColumns[column] && !forbiddenLeft[column] && !forbiddenRight[column]) {

            this.count++;
            forbiddenColumns[column] = true;
            forbiddenLeft[(column + n - 1) % n] = true;
            forbiddenRight[(column + 1) % n] = true;

            this.dfs(index + 1);

            this.count--;
            forbiddenColumns[column] = false;
            forbiddenLeft[(column + n - 1) % n] = false;
            forbiddenRight[(column + 1) % n] = false;
        }

        // 不放
        this.dfs(index + 1);
    }

}
