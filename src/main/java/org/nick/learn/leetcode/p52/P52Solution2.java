package org.nick.learn.leetcode.p52;

import java.util.Arrays;

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
            boolean[] arr1 = Arrays.copyOf(forbiddenColumns, n);
            boolean[] arr2 = Arrays.copyOf(forbiddenLeft, n);
            boolean[] arr3 = Arrays.copyOf(forbiddenRight, n);

            forbiddenColumns[column] = true;
            for (int i = n - 1; i >= 0; i--) {
                if (forbiddenLeft[i]) {
                    forbiddenLeft[i] = false;
                    forbiddenLeft[(i + n - 1) % n] = true;
                    i--;
                }
            }
            for (int i = 0; i < n; i++) {
                if (forbiddenRight[i]) {
                    forbiddenRight[i] = false;
                    forbiddenRight[(i + n) % n] = true;
                    i++;
                }
            }
            forbiddenLeft[(column + n - 1) % n] = true;
            forbiddenRight[(column + 1) % n] = true;

            this.count++;
            this.dfs(index + 1);
            this.count--;

            forbiddenColumns = arr1;
            forbiddenLeft = arr2;
            forbiddenRight = arr3;
        }

        // 不放
        this.dfs(index + 1);
    }

}
