package org.nick.learn.leetcode.p46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46Solution1 {

    // 自己摸索的题解，1ms 击败 96%
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        this.dfs(result, list, nums, used);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;

            this.dfs(result, list, nums, used);

            list.removeLast();
            used[i] = false;
        }
    }
}
