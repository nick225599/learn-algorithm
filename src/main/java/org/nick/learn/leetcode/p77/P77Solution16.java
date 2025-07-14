package org.nick.learn.leetcode.p77;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class P77Solution16 {
    public List<List<Integer>> collections;
    public int n;
    public int k;

    // 民间 击败 99% 版本
    // 通过递归直接枚举出所有的可能结果，不需要像官方题解那样进行选择或跳过
    // 但是这个解法不具备通用性，利用了题目的特性进行了针对性的性能优化
    // 而官方题解一是标准回溯法的 “选择 - 递归 - 撤销” 流程，更具通用性、更具教育意义

    // 但是想到这个解法的真强啊
    public List<List<Integer>> combine(int n, int k) {
        this.collections = new ArrayList<>();
        this.n = n;
        this.k = k;
        assemble(collections, new Integer[k], 0, 1);
        return collections;
    }

    private void assemble(List<List<Integer>> collections, Integer[] elementList, int pos, int startNum) {
        if (pos == k) {
            Integer[] newArray = new Integer[k];
            System.arraycopy(elementList, 0, newArray, 0, k);
            collections.add(Arrays.asList(newArray));
            return;
        }
        for (int i = startNum; i <= n; i++) {
            elementList[pos] = i;
            assemble(collections, elementList, pos + 1, i + 1);
        }
    }


}
