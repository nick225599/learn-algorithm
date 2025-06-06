package org.nick.learn.leetcode.p54;

import java.util.ArrayList;
import java.util.List;

public class P54Solution3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int total = n * m;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>(total);
        String direction = "右";
        for (int k = 0; k < total; k++) {
            result.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            int[] nextIJ = this.nextIJ(direction, i, j);
            if (nextIJ[0] < 0 || nextIJ[0] >= n
                    || nextIJ[1] < 0 || nextIJ[1] >= m
                    || matrix[nextIJ[0]][nextIJ[1]] == Integer.MAX_VALUE) {
                direction = this.nextDirection(direction);
                nextIJ = this.nextIJ(direction, i, j);
            }
            i = nextIJ[0];
            j = nextIJ[1];
        }
        return result;
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

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/spiral-matrix/solutions/275393/luo-xuan-ju-zhen-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
