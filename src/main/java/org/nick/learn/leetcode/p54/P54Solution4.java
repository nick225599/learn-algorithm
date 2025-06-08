package org.nick.learn.leetcode.p54;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P54Solution4 {
    // 上一个题解用  String direction 和 boolean[][] visited ， 是否需要转向
    // 但其实可以通过计算直接算出来，简化这个 O(nm) 的空间损耗
    // 一圈圈往里获取元素并写入 List<Integer>
    // 这也是我第一反应的解法，
    // 只是不会写成代码，写着写着就自然而言想用标记来替代坐标换算逻辑
    //TODO nick 尝试将坐标换算逻辑写出来
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        List<Integer> result = new ArrayList<>();
        while (result.size() < n * m) {
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

            if (left == right && top == bottom) {
                break;
            }

            if (top + 1 <= bottom - 1) {
                top++;
                bottom--;
            }
            if (left + 1 <= right - 1) {
                left++;
                right--;
            }
        }

        return result;
    }
}
