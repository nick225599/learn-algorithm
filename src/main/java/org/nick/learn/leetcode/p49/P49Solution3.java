package org.nick.learn.leetcode.p49;

import java.util.*;

public class P49Solution3 {


    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<>() {
            List<List<String>> list;

            private void init() {
                if (list == null) {
                    list = _groupAnagrams(strs);
                }
            }

            @Override
            public int size() {
                init();
                return list.size();
            }

            @Override
            public List<String> get(int i) {
                init();
                return list.get(i);
            }
        };
    }

    public List<List<String>> _groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.computeIfAbsent(sort(s), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String sort(String s) {
        char[] S = s.toCharArray();
        Arrays.sort(S);
        return new String(S);
    }

    // str 仅包含英文小写字母
    public int hash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sum += ch * ch * ch * ch  - ch * ch * ch - ch;
        }
        return sum;
    }


}
