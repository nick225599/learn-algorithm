package org.nick.learn.leetcode.problem15;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionB {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> tmpSet = new TreeSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 使用 nums[j]
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] tmp = new int[3];
                        tmp[0] = nums[i];
                        tmp[1] = nums[j];
                        tmp[2] = nums[k];
                        Arrays.sort(tmp);
                        tmpSet.add(tmp[0] + "," + tmp[1] + "," + tmp[2]);
                    }
                }
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        for (String str : tmpSet) {
            List<Integer> list = Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            output.add(list);

        }
        return output;
    }
}