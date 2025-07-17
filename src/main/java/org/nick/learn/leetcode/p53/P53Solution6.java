package org.nick.learn.leetcode.p53;

public class P53Solution6 {

    static class CompoundSum {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        public CompoundSum(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    // 分支法
    // 有点跟第 148 题链表排序神似
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        CompoundSum compoundSum = maxSubArray(nums, 0, n - 1);
        return compoundSum.mSum;
    }

    // 找最大值
    private CompoundSum maxSubArray(int[] nums, int i, int j) {
        if (i == j) {
            return new CompoundSum(nums[i], nums[i], nums[i], nums[i]);
        }

        // 分
        int mid = i + ((j - i) >> 1);
        CompoundSum l = maxSubArray(nums, i, mid);
        CompoundSum r = maxSubArray(nums, mid + 1, j);

        // 合
        // lSum 表示 [l,r] 内以 l 为左端点的最大子段和
        int lSum = l.iSum + r.lSum;
        // rSum 表示 [l,r] 内以 r 为右端点的最大子段和
        int rSum = l.rSum + r.iSum;
        // mSum 表示 [l,r] 内的最大子段和
        int mSum = Math.max(
                Math.max(l.mSum, r.mSum),
                l.rSum + r.lSum
        );
        // iSum 表示 [l,r] 的区间和
        int iSum = l.iSum + r.iSum;
        return new CompoundSum(lSum, rSum, mSum, iSum);
    }


}
