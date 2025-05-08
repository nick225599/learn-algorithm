package org.nick.learn.leetcode.p134;

/**
 * 力扣 134. 加油站
 */
public class P134Solution5 {

    /**
     * 贪心算法 不回溯
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ) {
            int g = gas[i]; // 初始站点直接加油

            int j;
            for (j = 0; j < n; j++) {
                g -= cost[(i + j) % n]; // 减去驶入当前站点所需的油量
                if (g < 0) {
                    break;
                }
                g += gas[(i + j + 1) % n]; // 在当前站点加油
            }

            // 判断是否走完一圈
            if (j == n) {
                return i;
            } else {
                System.out.println("i1 : " + i);
                i = i + j + 1;
                System.out.println("i2 : " + i);
            }
        }

        return -1;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/gas-station/solutions/488357/jia-you-zhan-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
