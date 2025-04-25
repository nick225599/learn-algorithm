package org.nick.learn.leetcode.p427;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    /**
     * 将二维数组用四叉树表示
     *
     * @param grid        用于创建四叉树的二维数组
     * @param rowIndex    行起始坐标
     * @param columnIndex 列起始坐标
     * @param length      矩阵长度，2 表示 2*2，4 表示 4*4，8 表示 8*8，以此类推
     */
    private Node construct(int[][] grid, int rowIndex, int columnIndex, int length) {
        boolean same = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[rowIndex + i][columnIndex + j] != grid[rowIndex][columnIndex]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(grid[rowIndex][columnIndex] == 1, true);
        }

        Node topLeft = construct(grid,
                rowIndex, columnIndex, length / 2);
        Node topRight = construct(grid,
                rowIndex, columnIndex + length / 2, length / 2);
        Node bottomLeft = construct(grid,
                rowIndex + length / 2,columnIndex, length / 2);
        Node bottomRight = construct(grid,
                rowIndex + length / 2, columnIndex + length / 2, length / 2);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }


}
