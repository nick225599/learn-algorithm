package org.nick.learn.leetcode.p39;

import java.util.LinkedList;
import java.util.List;

public class P39Solution1 {

    // 自己摸索出来的解法，
    // 3ms 击败 26%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, new LinkedList<>(), 0, target, candidates, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> output, int sum, int target, int[] candidates,
                           int startIndex) {
        if(sum > target){
            return;
        }
        if(sum == target){
            ans.add(new LinkedList<>(output));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            int candidate = candidates[i];
            output.add(candidate);
            backtrack(ans, output, sum + candidate, target, candidates, i);
            output.removeLast();
        }
    }
}
