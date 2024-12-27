package org.nick.learn.leetcode.problems427;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class SolutionB {
    public Node construct(int[][] grid) {
        int[][] pre = this.pre(grid, grid.length);
        return construct(grid, pre, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int[][] pre, int rowIndex, int columnIndex, int length) {
        // 根据 rowIndex, columnIndex, length 算出子矩阵的元素和
        int sum = pre[rowIndex + length][columnIndex + length]
                - pre[rowIndex + length][columnIndex]
                - pre[rowIndex][columnIndex + length]
                + pre[rowIndex][columnIndex];
        boolean same = sum == 0 || sum == length * length;
        if (same) {
            return new Node(grid[rowIndex][columnIndex] == 1, true);
        }

        Node topLeft = construct(grid, pre, rowIndex, columnIndex, length / 2);
        Node topRight = construct(grid, pre, rowIndex, columnIndex + length / 2, length / 2);
        Node bottomLeft = construct(grid, pre, rowIndex + length / 2, columnIndex, length / 2);
        Node bottomRight = construct(grid, pre, rowIndex + length / 2, columnIndex + length / 2, length / 2);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private int[][] pre(int[][] grid, int length) {
        int[][] pre = new int[length + 1][length + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        SolutionB solution = new SolutionB();
        int[][] grid;
        Node root;

        grid = new int[][]{
                {0, 1},
                {1, 0}
        };
        root = solution.construct(grid);
        Assert.assertEquals("[0,1,1,0]", root.toString());

        grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };

        root = solution.construct(grid);
        Assert.assertEquals("[1,[0,0,1,1],1,0]", root.toString());
    }
}
