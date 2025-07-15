package org.nick.learn.leetcode.p39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 民间 1ms 解法
public class P39Solution4 {

    // 看上去跟我的解法差不多啊
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int remain, int start,
                          List<Integer> path, List<List<Integer>> result) {
        // remain -> target
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝：如果当前元素大于剩余值，跳过（后续的值更大，无需继续）
            if (candidates[i] > remain)
                continue;
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, path, result);
            path.removeLast();
        }
    }

}
