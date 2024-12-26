package org.nick.learn.leetcode.problems427;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length, 0, grid.length);
    }

    /**
     * 将二维数组用四叉树表示
     *
     * @param grid         用于创建四叉树的二维数组
     * @param rowIndex     行起始下标
     * @param columnLength 行长度
     * @param rowLength    列起始下标
     * @param columnIndex  列长度
     */
    private Node construct(int[][] grid, int rowIndex, int columnIndex, int rowLength, int columnLength) {
        boolean same = true;
        for (int i = rowIndex; i < rowLength; i++) {
            for (int j = columnIndex; j < columnLength; j++) {
                if (grid[i][j] != grid[rowIndex][columnIndex]) {
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

        //TODO sunchuansheng 下标处理不对，看不懂源码，怎么不需要处理最小长度的场景？
        return new Node(false, false,
                construct(grid, -1, -1, -1, -1),
                construct(grid, -1, -1, -1, -1),
                construct(grid, -1, -1, -1, -1),
                construct(grid, -1, -1, -1, -1)
        );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid;
        Node root;

        grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
        root = solution.construct(grid);
        Assert.assertEquals("[0,1,1,0]", root.toString());

        // [
        grid = new int[][]{
                //   [1,1,1,1,0,0,0,0],
                {1, 1, 1, 1, 0, 0, 0, 0},

                //   [1,1,1,1,0,0,0,0],
                {1, 1, 1, 1, 0, 0, 0, 0},

                //   [1,1,1,1,1,1,1,1],
                {1, 1, 1, 1, 1, 1, 1, 1},

                //   [1,1,1,1,1,1,1,1],
                {1, 1, 1, 1, 1, 1, 1, 1},

                //   [1,1,1,1,0,0,0,0],
                {1, 1, 1, 1, 0, 0, 0, 0},

                //   [1,1,1,1,0,0,0,0],
                {1, 1, 1, 1, 0, 0, 0, 0},

                //   [1,1,1,1,0,0,0,0],
                {1, 1, 1, 1, 0, 0, 0, 0},

                //   [1,1,1,1,0,0,0,0]
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        // ]

        root = solution.construct(grid);
        Assert.assertEquals("[0,1,1,0]", root.toString());
    }
}
