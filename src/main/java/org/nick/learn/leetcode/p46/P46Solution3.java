package org.nick.learn.leetcode.p46;

import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46Solution3 {

    // 参考官方题解降低空间复杂度
    // 0ms 击败 100%
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0);
        return res;
    }

    public void backtrack(int[] arr, List<List<Integer>> res, int insertPos) {
        if (insertPos == arr.length) {
            List<Integer> output = new ArrayList<>(arr.length);
            for(int i : arr){
                output.add(i);
            }
            res.add(output);
        }

        for (int i = insertPos; i < arr.length; i++) {
            this.swap(arr, insertPos, i);
            backtrack(arr, res, insertPos + 1);
            this.swap(arr, insertPos, i);
        }

    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}
