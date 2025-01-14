package org.nick.learn.leetcode.problem15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final Solution solution = new Solution();

    @Test
    void threeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = solution.threeSum(nums);
        assertEquals(2, output.size());
        for (List<Integer> l : output) {
            l.sort(Integer::compareTo);
        }
        output.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                int compareToResult = o1.get(i).compareTo(o2.get(i));
                if (0 != compareToResult) {
                    return compareToResult;
                }
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (List<Integer> l : output) {
            sb.append(Arrays.toString(l.toArray())).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        assertEquals("[-1, -1, 2], [-1, 0, 1]", sb.toString());
    }

    @Test
    void case2() {
        int[] nums = new int[]{0,1,1};
        List<List<Integer>> output = solution.threeSum(nums);
        assertEquals(0, output.size());
    }

    @Test
    void case3() {
        int[] nums = new int[]{0,0,0};
        List<List<Integer>> output = solution.threeSum(nums);
        assertEquals(1, output.size());
        String str = Arrays.toString(output.getFirst().stream().mapToInt(Integer::intValue).toArray());
        assertEquals("[0, 0, 0]", str);
    }
}