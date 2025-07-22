package org.nick.learn.leetcode.p33;

public class P33Solution2 {

    // 自己尝试二分
    // 0ms 击败 100%
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n * 3 - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int num = nums[m % n];
            if (num < target) {
                // l, m, target, r
                // target 在 m 的右边 [m+1, r]
                l = m + 1;
                if (l > r) {
                    return -1;
                }
                while (true) {
                    int newM = l + ((r - l) >> 1);
                    int newNum = nums[newM % n];
                    if (newNum <= num) {
                        r = newM - 1;
                        if (l > r) {
                            return -1;
                        }
                    } else {
                        break;
                    }
                }

                // 试算一下，如果新 [m+1, r] 的中间节点值m2 比 num 小，说明新 m 跨界了
                // r = m2, [m + 1, r2]
            } else if (num > target) {
                // l target m r
                // target 在 m 的左边
                r = m - 1;
                if (l > r) {
                    return -1;
                }
                while (true) {
                    int newM = l + ((r - l) >> 1);
                    int newNum = nums[newM % n];
                    if (newNum >= num) {
                        l = newM + 1;
                        if (l > r) {
                            return -1;
                        }
                    } else {
                        break;
                    }
                }

            } else {
                return m % n;
            }
        }
        return -1;
    }
}
