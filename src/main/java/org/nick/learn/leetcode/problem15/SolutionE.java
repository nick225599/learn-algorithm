package org.nick.learn.leetcode.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 */
public class SolutionE {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        // 枚举 a
        for (int first = 0; first < nums.length - 2; first++) {
            // 需要和上一次枚举的数不相同
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;             // c 对应的指针初始指向数组的最右端

            // 枚举 b
            while (second < third) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                int sum = nums[first] + nums[third] + nums[second];
                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    List<Integer> singleList = new ArrayList<>(3);
                    singleList.add(nums[first]);
                    singleList.add(nums[third]);
                    singleList.add(nums[second]);
                    output.add(singleList);
                    second++;
                }
            }

        }
        return output;
    }
}
