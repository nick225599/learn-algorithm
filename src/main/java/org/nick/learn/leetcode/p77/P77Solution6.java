package org.nick.learn.leetcode.p77;

import java.util.LinkedList;
import java.util.List;

public class P77Solution6 {
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> list = new LinkedList<>();
    private int n;
    private int k;

    // 24ms 击败30%
    public List<List<Integer>> combine(int n, int k) {
        this.result = new LinkedList<>();
        this.list = new LinkedList<>();
        this.n = n;
        this.k = k;
        this.dfs(1);
        return result;
    }

    private void dfs(int i) {
        // 跳过太多，不可能凑够 k 个数，直接结束
        if (list.size() + n - i + 1 < k) {
            return;
        }

        // 不放
        this.dfs(i + 1);

        // 放
        list.add(i);
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
        } else {
            this.dfs(i + 1);
        }
        list.removeLast();
    }


}
