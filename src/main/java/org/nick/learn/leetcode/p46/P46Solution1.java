package org.nick.learn.leetcode.p46;

import java.util.*;

public class P46Solution1 {

    // 朴素解法
    // 时间复杂度 O(n * klogk) k 字符串最大的长度
    // 但空间复杂度 O(n)
    // 能优化吗？怎么优化？
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.computeIfAbsent(hash(str), _ -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String hash(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
