package org.nick.learn.leetcode.p53;

public class P53Solution6 {

    // 分治法
    // 有点跟第 148 题链表排序神似
    // 8ms
    // 时间复杂度 logn
    // 空间复杂度 logn

    // 题外话
    //「方法二」相较于「方法一」来说，时间复杂度相同，但是因为使用了递归，
    // 并且维护了四个信息的结构体，运行的时间略长，
    // 空间复杂度也不如方法一优秀，而且难以理解。
    //
    // 那么这种方法存在的意义是什么呢？
    //
    //对于这道题而言，确实是如此的。但是仔细观察「方法二」，它不仅可以解决区间 [0,n−1]，
    // 还可以用于解决任意的子区间 [l,r] 的问题。
    // 如果我们把 [0,n−1] 分治下去出现的所有子区间的信息都用堆式存储的方式记忆化下来，
    // 即建成一棵真正的树之后，我们就可以在 O(logn) 的时间内求到任意区间内的答案，
    // 我们甚至可以修改序列中的值，做一些简单的维护，之
    // 后仍然可以在 O(logn) 的时间内求到任意区间内的答案，
    // 对于大规模查询的情况下，这种方法的优势便体现了出来。
    //
    // 这棵树就是上文提及的一种神奇的数据结构——线段树。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
