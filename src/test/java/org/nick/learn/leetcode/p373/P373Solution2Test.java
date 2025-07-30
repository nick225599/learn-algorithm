package org.nick.learn.leetcode.p373;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P373Solution2Test {
    P373Solution2 solution = new P373Solution2();

    @Test
    void kSmallestPairs() {
        solution.kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 20);
    }

    @Test
    void testKSmallestPairs() {
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        // [1,2],[1,4],[1,6]]
        int[][] ans2 = new int[][]{
                new int[]{1, 2},
                new int[]{1, 4},
                new int[]{1, 6}
        };
        for (int i = 0; i < ans2.length; i++) {
            int sum1 = this.sum(ans, i);
            int sum2 = this.sum(ans2, i);
            assertEquals(sum2, sum1, "excepted: " + Arrays.toString(ans2[i]));
        }
    }


    private int sum(int[][] ans2, int i) {
        int[] arr = ans2[i];
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    private int sum(List<List<Integer>> ans, int i) {
        List<Integer> arr = ans.get(i);
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    @Test
    void testKSmallestPairs2() {
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{-10,-4,0,0,6}, new int[]{3,5,6,7,8,100}, 10);
        int[][] ans2 = new int[][]{
                new int[]{-10,3},
                new int[]{-10,5},
                new int[]{-10,6},
                new int[]{-10,7},
                new int[]{-10,8},
                new int[]{-4,3},
                new int[]{-4,5},
                new int[]{-4,6},
                new int[]{-4,7},
                new int[]{0,3}
        };
        for (int i = 0; i < ans2.length; i++) {
            int sum1 = this.sum(ans, i);
            int sum2 = this.sum(ans2, i);
            assertEquals(sum2, sum1, "excepted: " + Arrays.toString(ans2[i])
                    + ", but actual: " + Arrays.toString(ans.get(i).toArray()));
        }
    }
}