package org.nick.learn.leetcode.p48;

public class p48Solution1 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while(top < bottom && left < right){
            // 1  2  3  4
            // 5  6  7  8
            // 9  10 11 12
            // 13 14 15 16
            for(int i = 0; i < right - left; i++){
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }



}
