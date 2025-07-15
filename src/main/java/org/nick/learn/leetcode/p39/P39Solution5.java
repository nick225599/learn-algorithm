package org.nick.learn.leetcode.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39Solution5 {

    // 用 ArrayList 就 1ms
    // 用 LinkedList 就 2ms
    // 就挺无语......
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, new ArrayList<>(), 0, target, candidates, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> output, int sum, int target, int[] candidates,
                           int startIndex) {
        if(sum == target){
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            int candidate = candidates[i];
            if(sum + candidate > target){
                continue;
            }
            output.add(candidate);
            backtrack(ans, output, sum + candidate, target, candidates, i);
            output.removeLast();
        }
    }

}
