package org.nick.learn.leetcode.p77;

import java.util.LinkedList;
import java.util.List;

public class P77Solution2 {

    // 直接优化，用 list
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        this.foo(result, n, 1, k, 0, null);
        return result;
    }

    private void foo(List<List<Integer>> result, int n, int ni, int k, int ki, List<Integer> list) {
        // 不放
        if (ni + 1 <= n) {
            this.foo(result, n, ni + 1, k, ki, list);
        }

        // 放
        if (list == null) {
            list = new LinkedList<>();
            list.add(ni);
        } else {
            list.set(ki, ni);
        }
        if (ki == k - 1) {
            result.add(list);
        } else {
            if (ni + 1 <= n) {
                this.foo(result, n, ni + 1, k, ki + 1, list);
                list.removeLast();
            }
        }
    }


}
