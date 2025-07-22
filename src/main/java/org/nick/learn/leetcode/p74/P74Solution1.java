package org.nick.learn.leetcode.p74;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P74Solution1 {

    // 0ms 击败100%
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 拉平整个二维数组进行二分查找
        int left = 0;
        int right = n * m - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            int num = matrix[mid / m][mid % m];
            if (target < num) {
                right = mid - 1;
            } else if (target > num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return matrix[left / m][left % m] == target;
    }

}
