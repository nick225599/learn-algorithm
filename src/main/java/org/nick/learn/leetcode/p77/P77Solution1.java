package org.nick.learn.leetcode.p77;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P77Solution1 {
    // Input: n = 4, k = 2
    // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        this.foo(result, n, 1, k, 0, new int[k]);
        return result;
    }

    private void foo(List<List<Integer>> result, int n, int ni, int k, int k1, int[] arr) {
        // 不放
        if (ni + 1 <= n) {
            this.foo(result, n, ni + 1, k, k1, arr);
        }

        // 放
        arr[k1] = ni;
        if (k1 == k - 1) {
            result.add(Arrays.stream(arr).boxed().toList());
        } else {
            if (ni + 1 <= n) {
                this.foo(result, n, ni + 1, k, k1 + 1, arr);
            }
        }
    }


}
