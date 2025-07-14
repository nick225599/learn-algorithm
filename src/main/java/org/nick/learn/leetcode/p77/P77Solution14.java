package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// 无哨兵版本
//nick 20250714 这个解法回头又要忘了，自己怎么推衍出这种解法...得能回想起来二进制01数组的变化规律
@Slf4j
public class P77Solution14 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < k) {
            return result;
        }

        List<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(i + 1);
        }
        result.add(new ArrayList<>(list));
        if (n == k) {
            return result;
        }
        while (true) {
            int i;
            for (i = 0; i < k - 1 && list.get(i) + 1 == list.get(i + 1); i++) {
                list.set(i, i + 1);
            }
            list.set(i, list.get(i) + 1);
            if (list.get(i) > n) {
                break;
            }
            result.add(new ArrayList<>(list));
        }

        // 规则一：x 的最低位为 1，这种情况下，如果末尾由 t 个连续的 1，
        // 我们直接将倒数第 t 位的 1 和倒数第 t+1 位的 0 替换，
        // 就可以得到 next(x)。
        // 如 0011→0101，0101→0110，1001→1010，1001111→1010111。


        // 规则二：x 的最低位为 0，这种情况下，
        // 末尾有 t 个连续的 0，而这 t 个连续的 0 之前有 m 个连续的 1，
        // 我们可以将倒数第 t+m 位置的 1 和倒数第 t+m+1 位的 0 对换，
        // 然后把倒数第 t+1 位到倒数第 t+m−1 位的 1 移动到最低位。
        // 如 0110→1001，1010→1100，1011100→1100011。


        return result;

    }


}
