package org.nick.learn.leetcode.p221;

import java.util.HashMap;
import java.util.Map;

//@Slf4j
public class P221Solution2 {


    Map<String, Integer> cache;

    // 自己写的，超时了
    // 超时就加缓存

    // 83ms 击败 7.33%
    // 所以压根不需要缓存，只是自己写错了
    public int maximalSquare(char[][] matrix) {
        int area = 0;
        int sideLength = 0;

        cache = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newSideLength = this.checkNewSideLength(matrix, m, n, i, j, sideLength);
                if (newSideLength > sideLength) {
                    sideLength = newSideLength;
                    area = sideLength * sideLength;
                }
            }
        }

        return area;
    }

    // 是否存在比 sideLength 更大的边长？
    private int checkNewSideLength(char[][] matrix, int m, int n, int i, int j, int sideLength) {

        // 从 cache 里可以提前知道以 （i, j） 为左上角，最大的全 1 正方形边长为 ？
        Integer max = cache.get(i + "," + j);
        if (null != max) {
            return max;
        }

        int ans = sideLength;
        for (int newSideLength = sideLength + 1; true; newSideLength++) {
            int endI = i + newSideLength - 1;
            if (endI >= m) {
                break;
            }
            int endJ = j + newSideLength - 1;
            if (endJ >= n) {
                break;
            }

            if (allOne(matrix, i, j, endI, endJ)) {
//                if (newSideLength == 3) {
//                    log.info("1, i: " + i + ", j: " + j + ", endI: " + endI + ", endJ: " + endJ);
//                }
                ans = newSideLength;
            } else {
                break;
            }
        }
        return ans;
    }

    private boolean allOne(char[][] matrix, int i, int j, int endI, int endJ) {
        for (int a = i; a <= endI; a++) {
            for (int b = j; b <= endJ; b++) {
                if (matrix[a][b] == '0') {

                    // 可以知道以 (i, j) ~ (a - 1, b - 1) 为左上角，形成的全 1 矩阵，右下角只能是 (a - 1, b - 1)
                    for (int x = i; x <= a - 1; x++) {
                        for (int y = j; y <= b - 1; y++) {
                            int length = x - i + 1;
                            cache.put(x + "," + y, length);

//                            if (a - x + 1 == 3) {
//                                log.info("(i, j): ({}, {}), (x, y): ({}, {})", i, j, x, y );
//                                log.info("2, i: " + i + ", j: " + j + ", endI: " + endI + ", endJ: " + endJ);
//                            }
                        }
                    }


                    return false;
                }
            }
        }
        return true;
    }
}
