package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Slf4j
public class P77Solution11 {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return new LinkedList<>();
        }
        if (n == k) {
            List<Integer> list = new ArrayList<>(k);
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            List<List<Integer>> ans = new LinkedList<>();
            ans.add(list);
            return ans;
        }

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new ArrayList<>(k);

        //TODO nick 20250711 学习下二进制枚举法
        return null;

    }


}
