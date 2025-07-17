package org.nick.learn.leetcode.p53;

public class P53Solution6 {

    // 分治法
    // 有点跟第 148 题链表排序神似
    // 8ms
    // 时间复杂度 logn
    // 空间复杂度 logn
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] compoundSum = maxSubArray(nums, 0, n - 1);
        return compoundSum[2];
    }

    // 找最大值
    private int[] maxSubArray(int[] nums, int i, int j) {
        if (i == j) {
            return new int[]{nums[i], nums[i], nums[i], nums[i]};
        }

        // 分
        int mid = i + ((j - i) >> 1);
        int[] l = maxSubArray(nums, i, mid);
        int[] r = maxSubArray(nums, mid + 1, j);

        // 合
        // lSum 表示 [l,r] 内以 l 为左端点的最大子段和
        int lSum = Math.max(l[0], l[3] + r[0]);
        // rSum 表示 [l,r] 内以 r 为右端点的最大子段和
        int rSum = Math.max(r[1], l[1] + r[3]);
        // mSum 表示 [l,r] 内的最大子段和
        int mSum = Math.max(
                Math.max(l[2], r[2]),
                l[1] + r[0]
        );
        // iSum 表示 [l,r] 的区间和
        int iSum = l[3] + r[3];
        return new int[]{lSum, rSum, mSum, iSum};
    }


}
