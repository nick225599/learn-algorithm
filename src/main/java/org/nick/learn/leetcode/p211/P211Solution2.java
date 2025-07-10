package org.nick.learn.leetcode.p211;

import java.util.HashMap;
import java.util.Map;

public class P211Solution2 {
    static class WordDictionary {
        public Map<Character, WordDictionary> sub;
        public boolean isEnd;

        public WordDictionary() {
            sub = new HashMap<>(26);
            isEnd = false;
        }

        public void addWord(String word) {
            WordDictionary cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.sub.containsKey(c)) {
                    cur.sub.put(c, new WordDictionary());
                }
                cur = cur.sub.get(c);
            }
            cur.isEnd = true;
        }

        // 1. 逐个字符匹配
        // 2. 匹配成功则下一个字符
        // 3. 匹配失败，
        //      则看下当前字符是否是 .
        //          如果是 . 则需要遍历当前字符的所有子串，判断是否存在复合条件的子串
        //              存在 return true
        //              不存在 return false
        //          如果不是，则直接匹配失败
        public boolean search(String word) {
            return this.search(word, 0, this);
        }

        private boolean search(String word, int index, WordDictionary dict) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (dict.sub.containsKey(c)) {
                    dict = dict.sub.get(c);
                } else if (c == '.') {
                    for (WordDictionary nextDict : dict.sub.values()) {
                        if (search(word, i + 1, nextDict)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return dict.isEnd;
        }


    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
