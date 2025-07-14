package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class P77Solution15 {

    // 民间 击败 99% 版本
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> collections = new ArrayList<>();
        assemble(collections, new Integer[k], 0, k, 1, n);
        return collections;
    }

    private static void assemble(List<List<Integer>> collections,
                                 Integer[] elementList,
                                 int pos, int total,
                                 int startNum, int num) {
        if (pos == total) {
            Integer[] newArray = new Integer[elementList.length];
            System.arraycopy(elementList, 0, newArray, 0, elementList.length);
            collections.add(Arrays.asList(newArray));
            return;
        }
        for (int i = startNum; i <= num; i++) {
            elementList[pos] = i;
            assemble(collections, elementList, pos + 1, total, i + 1, num);
        }
    }


}
