package org.nick.learn.leetcode.p39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P39Solution3 {
    List<List<Integer>> ans;
    List<Integer> list;
    int[] candidates;

    // 消化一下搜索回溯法
    // 2ms 击败 88%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new LinkedList<>();
        this.list = new LinkedList<>();
        this.candidates = candidates;
        this.dfs(0, target);
        return ans;
    }

    /**
     * @param i 被考虑的数的下标
     * @param target 要凑的数
     */
    private void dfs(int i, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 使用当前数
        int tmpTarget = target - candidates[i];
        if (tmpTarget >= 0) {
            list.add(candidates[i]);
            dfs(i, tmpTarget);
            list.removeLast();
        }

        // 不使用当前数
        if (i + 1 < candidates.length) {
            dfs(i + 1, target);
        }
    }


}
