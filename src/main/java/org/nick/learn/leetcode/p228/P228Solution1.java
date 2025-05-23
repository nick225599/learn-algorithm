package org.nick.learn.leetcode.p228;

import java.util.ArrayList;
import java.util.List;

public class P228Solution1 {

    // 遍历一次
    // 反而是耗时最长的......
    // 换成 stingbuilder 就快了
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return result;
        }
        int is = -1;
        int ip = -1;
        for (int i = 0; i < n; i++) {
            if (is == -1) {
                is = ip = i;
            } else if (nums[i] == nums[ip] + 1) {
                ip = i;
            } else if (nums[i] > nums[ip] + 1) {
                addString(nums, is, ip, result);
                is = ip = i;
            }
        }
        addString(nums, is, ip, result);
        return result;
    }

    public void addString(int[] nums, int is, int ip, List<String> result) {
        StringBuilder sb = new StringBuilder();
        if (is == ip) {
            sb.append(nums[is]);
        } else {
            sb.append(nums[is]).append("->").append(nums[ip]);
        }
        result.add(sb.toString());
    }
}
