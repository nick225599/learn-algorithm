package org.nick.learn.leetcode.p134;

/**
 * 力扣 134. 加油站
 */
public class P134Solution3 {

    /**
     * 没用，还是超出时间限制
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ) {
            int g = gas[i]; // 第一站先加油
            System.out.println("第一站，从第 " + (i + 1) + " 站点出发，加好油后，油箱余量: " + g);
            boolean outOfGas = false;
            int j;
            int preStop = i;
            for (j = 0; j < n; j++) {
                preStop = (i + j) % n;
                g -= cost[preStop]; // 驶入当前站点时，油箱所剩油量
                if (g < 0) {
                    outOfGas = true;
                    break;
                } else {
                    int curStop = (preStop + 1) % n;
                    g += gas[curStop];
                }
            }
            if (outOfGas) {
                //TODO nick 怎么处理循环起始站点的问题？
                if(preStop <= i){
                    return -1;
                }
                i = (preStop + 1) % n;
            } else {
                return i;
            }
        }
        return -1;
    }

}
