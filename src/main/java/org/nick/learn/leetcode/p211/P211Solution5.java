package org.nick.learn.leetcode.p211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P211Solution5 {


    // 171ms 民间 top0
    // 大数据量的情况下 search() 会需要消耗 所有 word 总数的 时间复杂度，
    // 而前缀法只需要被搜索的单词的长度的时间复杂度，性能更优
    //
    // 改成 set 会降低空间复杂度，但是空间复杂度依旧高于数据量大且存在重复前缀词汇的情况下
    //
    // 此题 At most 10^4 calls will be made to addWord and search.
    // 也就是最多 10000 个词汇
    static class WordDictionary {

        Map<Integer, List<String>> map;

        /** Initialize your data structure here. */
        public WordDictionary() {
            map = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            int len = word.length();
            if (!map.containsKey(len)){
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(len, list);
            } else{
                map.get(len).add(word);
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            int len = word.length();
            if (!map.containsKey(len)) return false;
            else{
                List<String> list = map.get(len);
                for (String s: list){
                    if (helper(s, word)) return true;
                }
                return false;
            }
        }

        public boolean helper(String s, String word){
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') return false;
            }
            return true;
        }
    }

}


