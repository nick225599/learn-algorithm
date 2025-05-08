package org.nick.learn.leetcode.p134;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P134Solution1Test {

    P134Solution1 solution = new P134Solution1();

    @Test
    void canCompleteCircuit() {
        // TODO nick 20250508 为啥二号加油站也行？
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, startIndex);

        //        输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        //        输出: 3
        //        解释:
        //        从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        //        开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        //        开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        //        开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        //        开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        //        开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        //        因此，3 可为起始索引。
    }
}