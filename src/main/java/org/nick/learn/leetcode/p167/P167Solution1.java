package org.nick.learn.leetcode.p167;

public class P167Solution1 {
    // 时间复杂度 O(nlogn)
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (left == numbers[mid]) {
                    return new int[]{i + 1, mid + 1};
                }
                if (left < numbers[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return null;
    }
}
