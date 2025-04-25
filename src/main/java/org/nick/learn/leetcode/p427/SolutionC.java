package org.nick.learn.leetcode.p427;

import lombok.extern.slf4j.Slf4j;


/**
 * 比较直观，拆（递归）和合都要执行 logN 次
 * 矩阵越大，性能越不如 SolutionB 前缀和方案，不管数据能不能合并，能合并的话，性能差距更大
 */
@Slf4j
public class SolutionC {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int rowIndex, int columnIndex, int length) {
        if (length == 1) {
            return new Node(grid[rowIndex][columnIndex] == 1, true);
        }
        Node topLeft = construct(grid, rowIndex, columnIndex, length / 2);
        Node topRight = construct(grid, rowIndex, columnIndex + length / 2, length / 2);
        Node bottomLeft = construct(grid, rowIndex + length / 2, columnIndex, length / 2);
        Node bottomRight = construct(grid, rowIndex + length / 2, columnIndex + length / 2, length / 2);
        Node n = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        // 判断是否可以合并子页
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            n = new Node( topLeft.val, true);
        }
        return n;

    }



}
