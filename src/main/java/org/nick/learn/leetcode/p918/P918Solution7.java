package org.nick.learn.leetcode.p918;

public class P918Solution7 {

    // 2ms 击败 100%
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = kadane(nums, n, true);
        if (max < 0) {
            return max;
        }
        int min = kadane(nums, n, false);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return Math.max(max, sum - min);
    }

    // JVM 对「函数封装的代码」更友好：函数内部的逻辑相对独立（输入、输出明确，变量作用域封闭），
    // JIT 编译时更容易识别为「热点代码」并进行深度优化（如指令重排、循环展开、寄存器分配更高效）。
    // 例如，Solution9 的 kndane 方法被调用两次，JVM 可能将其编译为高度优化的机器码，两次调用共享同一份优化结果。

    // 把这个 kadane 方法写在 maxSubarraySumCircular 就变成 3ms 了
    int kadane(int[] nums, int n, boolean calculateMax) {
        int pre = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            pre = calculateMax ? Math.max(nums[i], nums[i] + pre) : Math.min(nums[i], nums[i] + pre);
            ans = calculateMax ? Math.max(ans, pre) : Math.min(ans, pre);
        }
        return ans;
    }

}
