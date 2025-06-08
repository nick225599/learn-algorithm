package org.nick.learn.leetcode.p54;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P54Solution6 {

    // 看了官方题解后进行一下优化
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        List<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            int i, j;
            for (i = top, j = left; j <= right; j++) {
                result.add(matrix[i][j]);
            }
            for (i = top + 1, j = right; i <= bottom; i++) {
                result.add(matrix[i][j]);
            }
            for (i = bottom, j = right - 1; top != bottom && j >= left; j--) {
                result.add(matrix[i][j]);
            }
            for (i = bottom - 1, j = left; left != right && i >= top + 1; i--) {
                result.add(matrix[i][j]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return result;
    }
}
