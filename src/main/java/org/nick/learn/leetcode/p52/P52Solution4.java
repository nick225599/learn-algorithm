package org.nick.learn.leetcode.p52;

public class P52Solution4 {
    int n;
    int result;
    boolean[] arr1;
    boolean[] arr2;
    boolean[] arr3;

    // 0ms 击败100%
    public int totalNQueens(int n) {
        this.n = n;
        this.result = 0;
        this.arr1 = new boolean[n];
        this.arr2 = new boolean[2 * n - 1];
        this.arr3 = new boolean[2 * n - 1];
        this.backtrace(0);
        return result;
    }

    private void backtrace(int row) {
        if (row == n) {
            this.result++;
            return;
        }

        for (int column = 0; column < n; column++) {
            if (arr1[column] || arr2[column - row + n - 1] || arr3[column + row]) {
                continue;
            }

            arr1[column] = true;
            arr2[column - row + n - 1] = true;
            arr3[column + row] = true;
            backtrace(row + 1);
            arr1[column] = false;
            arr2[column - row + n - 1] = false;
            arr3[column + row] = false;
        }
    }


}
