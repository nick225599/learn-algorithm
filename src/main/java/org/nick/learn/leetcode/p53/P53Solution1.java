package org.nick.learn.leetcode.p53;

import java.util.ArrayList;
import java.util.List;

public class P53Solution1 {

    // 超出时间限制
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int maximum  = nums[0];
        List<Integer> list = new ArrayList<>(length);
        for (int n : nums) {
            list.add(n);
            maximum  = Math.max(maximum , n);
        }
        if (maximum  <= 0) {
            return maximum ;
        }

        int max = nums[0];
        for (int i = 0; i < length; i++) {
            max = Math.max(max, this.maxSubArray(list.subList(i, length)));
        }
        return max;
    }

    private int maxSubArray(List<Integer> list) {
        while (list.size() > 1) {
            list = this.merge(list);
        }
        return list.getFirst();
    }

    private List<Integer> merge(List<Integer> list) {
        this.tidyUp(list);

        List<Integer> newList = new ArrayList<>();

        // 1. 把开头的正整数累加成 1 个数
        int sum = 0;
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i) >= 0) {
                sum += list.get(i);
            } else {
                break;
            }
        }
        newList.add(sum);

        while (i < list.size()) {
            sum = 0;
            boolean positiveNumberExist = false;
            for (; i < list.size(); i++) {
                sum += list.get(i);
                if (list.get(i) > 0 && !positiveNumberExist) {
                    positiveNumberExist = true;
                }
                if (positiveNumberExist && i + 1 < list.size() && list.get(i + 1) < 0) {
                    i++;
                    break;
                }
            }
            newList.add(sum);
        }

        return newList;
    }

    private void tidyUp(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                nums.set(i, 0);
            } else {
                break;
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) < 0) {
                nums.set(i, 0);
            } else {
                break;
            }
        }
    }
}
