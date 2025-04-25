package org.nick.learn.leetcode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 尝试去掉去重逻辑
 */
public class SolutionD {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int target = -nums[i] - nums[j];
                        int searchResult = Arrays.binarySearch(nums, j + 1, nums.length, target);
                        if (searchResult >= 0) {
                            List<Integer> singleList = new ArrayList<>(3);
                            singleList.add(nums[i]);
                            singleList.add(nums[j]);
                            singleList.add(target);
                            output.add(singleList);
                        }
                    }
                }
            }
        }
        return output;
    }
}
