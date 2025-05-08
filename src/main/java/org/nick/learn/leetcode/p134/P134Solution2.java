package org.nick.learn.leetcode.p134;

/**
 * 力扣 134. 加油站
 */
public class P134Solution2 {

    /**
     * 没用，还是超出时间限制
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] arr1 = new int[n]; // 从当前站点加油，并驶入下一个站点，对油量的影响。
        for (int i = 0; i < n; i++) {
            arr1[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for (int arr : arr1) {
            sum += arr;
        }
        if (sum < 0) {
            return -1;
        }


        for (int i = 0; i < n; i++) {
            int tmpSum = 0;
            boolean tmpSumLt0 = false;
            for (int j = 0; j < n; j++) {
                tmpSum += arr1[(i + j) % n];
                if (tmpSum < 0) {
                    tmpSumLt0 = true;
                    break;
                }
            }
            if (!tmpSumLt0) {
                return i;
            }
        }

        return -1;
    }

}
