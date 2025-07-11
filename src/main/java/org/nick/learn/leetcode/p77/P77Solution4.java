package org.nick.learn.leetcode.p77;

import java.util.LinkedList;
import java.util.List;

public class P77Solution4 {
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> list = new LinkedList<>();
    private int n;
    private int k;

    // 怎么还是 38ms 击败 7% ？？？
    public List<List<Integer>> combine(int n, int k) {
        this.result = new LinkedList<>();
        this.list = new LinkedList<>();
        this.n = n;
        this.k = k;
        this.dfs(1);
        return result;
    }

    private void dfs(int i) {
        // 不放
        if (i + 1 <= n) {
            this.dfs(i + 1);
        }

        // 放
        list.add(i);
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
        } else if (i + 1 <= n) { // 有 else 27ms 没有就是 36ms
            this.dfs(i + 1);
        }
        list.removeLast();
    }


}
