package org.nick.learn.leetcode.p54;

import java.util.ArrayList;
import java.util.List;

public class P54Solution3 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int total = n * m;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>(total);
        String direction = "右";
        for (int k = 0; k < total; k++) {
            result.add(matrix[i][j]);
            visited[i][j] = true;

            // 根据当前方向，试算出下个元素的位置
            int[] nextIJ = this.nextIJ(direction, i, j);

            // 根据试算结果，判断是否需要转向
            boolean atTheBoundary = this.isAtTheBoundary(nextIJ, matrix, visited);

            // 如果需要转向，则转向并重新计算下一个元素的位置
            if (atTheBoundary) {
                direction = this.nextDirection(direction);
                nextIJ = this.nextIJ(direction, i, j);
            }

            // 不会出现需要连续转向的情况，所以直接更新 i, j 即可
            i = nextIJ[0];
            j = nextIJ[1];
        }
        return result;
    }

    private boolean isAtTheBoundary(int[] nextIJ, int[][] matrix, boolean[][] visited) {
        return (nextIJ[0] < 0 || nextIJ[0] >= matrix.length)
                || (nextIJ[1] < 0 || nextIJ[1] >= matrix[0].length)
                || visited[nextIJ[0]][nextIJ[1]];
    }

    private int[] nextIJ(String direction, int i, int j) {
        return switch (direction) {
            case "上" -> new int[]{i - 1, j};
            case "下" -> new int[]{i + 1, j};
            case "左" -> new int[]{i, j - 1};
            case "右" -> new int[]{i, j + 1};
            default -> throw new IllegalArgumentException();
        };
    }

    private String nextDirection(String direction) {
        return switch (direction) {
            case "上" -> "右";
            case "下" -> "左";
            case "左" -> "上";
            case "右" -> "下";
            default -> throw new IllegalArgumentException();
        };
    }

}
