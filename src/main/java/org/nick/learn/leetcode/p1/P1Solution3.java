package org.nick.learn.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class P1Solution3 {
    // 空间复杂度 O(n)
    // 其实预处理 target 也行，比如 target = 9 肢解成 int[] arr = [1, 2, 3, 4, 5, 6, 7, 8]
    // 然后遍历 nums 看下 arr 中哪些元素在 nums 中存在
    // 最后遍历 nums 看下 i 和 target - 1 - i 的元素是否都存在，都存在就 return
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // 下标是已经存在的数，值是此数在 nums 中的下标 + 1
        Map<Integer, Integer> buff = new HashMap<>();
        buff.put(nums[0], 0);

        for (int i = 1; i < n; i++) {
            int diff = target - nums[i];
            if (buff.containsKey(diff)) {
                return new int[]{buff.get(diff), i};
            } else {
                buff.put(nums[i], i);
            }
        }
        return null;
    }



}
