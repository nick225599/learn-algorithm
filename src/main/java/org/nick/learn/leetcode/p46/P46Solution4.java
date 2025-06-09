package org.nick.learn.leetcode.p46;

import java.util.*;

public class P46Solution4 {

    // class Solution {
//         public List<List<String>> groupAnagrams(String[] strs) {
//             // 对每个字符串进行排序，并且将对应的字符串添加到对应的map中
//             Map<String, List<String>> map = new HashMap<>();
//             for(String s : strs){
//                 char[] chars = s.toCharArray();
//                 Arrays.sort(chars);
//                 String key = new String(chars);
//                 map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
//             }
//             return new ArrayList<>(map.values());
//         }
// }
    // 为啥这能快很多?
    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<>() {
            private List<List<String>> list;

            private void init() {
                if (list == null) list = _groupAnagrams(strs);
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
        // return _groupAnagrams(strs);
    }

    public List<List<String>> _groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.computeIfAbsent(rearrange(str), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String rearrange(String S) {
        char[] s = S.toCharArray();
        Arrays.sort(s);
        return new String(s);
    }
}
