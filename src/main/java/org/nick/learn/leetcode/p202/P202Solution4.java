package org.nick.learn.leetcode.p202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P202Solution4 {

    // 数学规律法，知道就行
    public boolean isHappy(int n) {
        Set<Integer> cycleMembers =
                new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/happy-number/solutions/224894/kuai-le-shu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
