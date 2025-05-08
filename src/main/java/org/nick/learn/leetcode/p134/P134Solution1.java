package org.nick.learn.leetcode.p134;

/**
 * 力扣 134. 加油站
 */
public class P134Solution1 {

    /**
     * 超出时间限制
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = 0; j < n + 1; j++) {
                int stopIndex = (i + j) % n;
                // 计算从上一站驶入当前站时的剩余油量
                if (j != 0) {
                    int preIndex = (stopIndex + n - 1) % n;
                    g = g - cost[preIndex];
                }
                if (g < 0) {
                    break; // 油不够了
                } else {
                    g += gas[stopIndex]; // 能加上油
                }

                // 判断是不是够一圈了
                if (j == n) {
                    return i;
                }
            }
        }

        return -1;

    }

}
