package org.nick.learn.leetcode.p77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P77Solution9 {
    // AI 优化版本
    // 32ms
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new LinkedList<>();
            List<Integer> tmpList;

            // 生成所有可能的组合，每个组合用二进制数表示
            for (int i = (1 << k) - 1; i < (1 << n); i++) {
                // 检查当前数字是否恰好有k个1
                if (Integer.bitCount(i) != k) {
                    continue;
                }

                tmpList = new ArrayList<>(k);
                // 遍历每一位，提取选中的元素
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        // 注意：题目中元素从1开始，所以加1
                        tmpList.add(j + 1);
                    }
                }

                ans.add(tmpList);
            }

            return ans;
        }
}
