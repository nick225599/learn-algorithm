package org.nick.learn.leetcode.p54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P54Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if(n == 1){
            List<Integer> result = new ArrayList<>();
            for(int i : matrix[0]){
                result.add(i);
            }
            return result;
        }
        if(m == 1){
            List<Integer> result = new ArrayList<>();
            for (int[] ints : matrix) {
                result.add(ints[0]);
            }
            return result;
        }

        int direction = 0;
        int total = n * m;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>(total);
        result.add(matrix[i][j]);
        matrix[i][j] = Integer.MAX_VALUE;

        while(result.size() < n * m){
            if (direction % 4 == 0) {
                if (matrix[i][++j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    if (j == m - 1) {
                        direction++;
                    }
                } else {
                    j--;
                    direction++;
                }
            } else if (direction % 4 == 1) {
                if (matrix[++i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    if (i == n - 1) {
                        direction++;
                    }
                } else {
                    i--;
                    direction++;
                }
            } else if (direction % 4 == 2) {
                if (matrix[i][--j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    if (j == 0) {
                        direction++;
                    }
                } else {
                    j++;
                    direction++;
                }
            } else {
                if (matrix[--i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    if (i == 0) {
                        direction++;
                    }
                } else {
                    i++;
                    direction++;
                }
            }
        }
        return result;
    }
}
