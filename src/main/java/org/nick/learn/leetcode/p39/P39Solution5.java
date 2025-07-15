package org.nick.learn.leetcode.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39Solution5 {
    List<List<Integer>> ans;
    List<Integer> list;
    int[] candidates;

    // 自己摸索出来的解法，
    // 3ms 击败 26%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new LinkedList<>();
        this.list = new LinkedList<>();
        this.candidates = candidates;

        backtrack(target, candidates.length - 1); // 从大到小挑
        return ans;
    }

    private void backtrack(int remain, int start) {
        if (remain == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }


        for (int i = start; i >= 0; i--) {
            //剪枝：如果当前元素大于剩余值，跳过（后续的值更大，无需继续）
            if (candidates[i] > remain)
                continue;
            list.add(candidates[i]);
            backtrack(remain - candidates[i], i );
            list.removeLast();
        }
    }

}
