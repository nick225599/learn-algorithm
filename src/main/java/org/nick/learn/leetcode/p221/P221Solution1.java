package org.nick.learn.leetcode.p221;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P221Solution1 {

    // 自己写的，超时了

    // 45ms 击败 9.27%
    public int maximalSquare(char[][] matrix) {
        int area = 0;
        int sideLength = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newSideLength = this.checkNewSideLength(matrix, m, n, i, j, sideLength);
                if (newSideLength > sideLength) {
                    sideLength = newSideLength;
                    area = sideLength * sideLength;
                }
            }
        }

        return area;
    }

    // 是否存在比 sideLength 更大的边长？
    private int checkNewSideLength(char[][] matrix, int m, int n, int i, int j, int sideLength) {
        int ans = sideLength;
        for (int newSideLength = sideLength + 1; true; newSideLength++) {
            int endI = i + newSideLength - 1;
            if (endI >= m) {
                break;
            }
            int endJ = j + newSideLength - 1;
            if (endJ >= n) {
                break;
            }

            if (allOne(matrix, m, n, i, j, endI, endJ)) {
                ans = newSideLength;
            } else {
                break;
            }
        }
        return ans;
    }

    private boolean allOne(char[][] matrix, int m, int n, int i, int j, int endI, int endJ) {
        for (int a = i; a <= endI; a++) {
            for (int b = j; b <= endJ; b++) {
                if (matrix[a][b] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
