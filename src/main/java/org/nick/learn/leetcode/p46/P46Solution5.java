package org.nick.learn.leetcode.p46;

import java.util.*;

public class P46Solution5 {

    // 原理跟 Solution2 一样
    public List<List<String>> groupAnagrams(String[] strs) {
        // 对每个字符串进行排序，并且将对应的字符串添加到对应的map中
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.computeIfAbsent(hash(s), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private int hash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sum += (ch * (ch - 1) * ch * ch - ch);
        }
        return sum;
    }
}
