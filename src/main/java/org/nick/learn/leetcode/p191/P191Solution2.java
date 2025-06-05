package org.nick.learn.leetcode.p191;

public class P191Solution2 {
        // 官方题解，时间复杂度也是 O(logn)，
        // 但是性能比 Solution1 强
        public int hammingWeight(int n) {
            int ret = 0;
            while (n != 0) {
                n &= n - 1;
                ret++;
            }
            return ret;
        }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/number-of-1-bits/solutions/672082/wei-1de-ge-shu-by-leetcode-solution-jnwf/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
