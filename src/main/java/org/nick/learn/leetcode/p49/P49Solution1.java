package org.nick.learn.leetcode.p49;

import java.util.*;

public class P49Solution1 {

    // 朴素解法
    // 时间复杂度 O(n * klogk) k 字符串最大的长度
    // 但空间复杂度 O(n)
    // 能优化吗？怎么优化？
    public List<List<String>> groupAnagrams(String[] strs) {
        // 对每个字符串进行排序，并且将对应的字符串添加到对应的map中
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
