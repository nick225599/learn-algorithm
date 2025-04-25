package org.nick.learn.leetcode.p200;

public class Solution4 {

    /**
     * 并查集
     */
    public int numIslands(char[][] grid) {
        DSU dsuInstance = new DSU(grid);

        // 怎么运用并查集？
        // 怎么初始化整个并查集？
        // A： 将 (x, y) 二位坐标转换为一个数字 i = x * 列数 + y
        // 遍历每个元素，如果是 1 判断每个元素是否要和前面 N 个岛屿进行合并？
        // A： 如果是 1 则判断上下左右是不是也是 1 ，也是 1 的话就跟当前点进行合并
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';

                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        dsuInstance.union(i, j, i - 1, j);
                    }
                    // 下
                    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                        dsuInstance.union(i, j, i + 1, j);
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        dsuInstance.union(i, j, i, j - 1);
                    }
                    // 右
                    if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                        dsuInstance.union(i, j, i, j + 1);
                    }
                }
            }
        }
        // 最后怎么统计岛屿数量？
        // A： 初始岛屿数就是所有元素的数量，合并一次，数量减 1，太机智了。
        return dsuInstance.islandsNum;
    }

    static class DSU {
        int[] parents;
        int[] rank;

        int islandsNum;

        int rowNum;
        int columnNum;

        public DSU(char[][] grid) {
            islandsNum = 0;

            rowNum = grid.length;
            columnNum = grid[0].length;

            int n = rowNum * columnNum;

            parents = new int[n];
            rank = new int[n];

            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < columnNum; j++) {
                    if (grid[i][j] != '1') {
                        continue;
                    }
                    int tmp = getIndex(i, j);
                    parents[tmp] = tmp;
                    islandsNum++;
                }
            }
        }

        // 递归路径压缩
        public int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }

        public int getIndex(int rowIndex, int columnIndex) {
            return rowIndex * columnNum + columnIndex;
        }

        public void union(int x1, int y1, int x2, int y2) {
            int a = getIndex(x1, y1);
            int b = getIndex(x2, y2);
            int parentA = find(a);
            int parentB = find(b);

            if (parentA == parentB) {
                return;
            }

            // 优化二、按秩合并
            if (rank[parentA] < rank[parentB]) {
                parents[parentA] = parentB; // A 挂 B
            } else if (rank[parentA] > rank[parentB]) {
                parents[parentB] = parentA; // B 挂 A
            } else {
                // 深度相同，任意选择一个方向合并
                parents[parentA] = parentB;
                rank[parentB]++;
            }

            islandsNum--;
        }
    }
}
