package org.nick.learn.leetcode.p211;

import java.util.HashMap;
import java.util.Map;

public class P211Solution1 {

}

class WordDictionary {
    public Map<Character, WordDictionary> sub;
    public boolean isEnd;

    public WordDictionary() {
        sub = new HashMap<>();
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        WordDictionary curAny = this;
        for (char c : word.toCharArray()) {
            if (!cur.sub.containsKey(c)) {
                WordDictionary next = new WordDictionary();
                cur.sub.put(c, next);
                curAny.sub.put(c, next); // 这个思路走不通，
                // a -> b -> c 和 a -> d -> c 时，第 2 层的 .
                // 需要下挂两个不同的 c，而现在只允许下挂一个 c

                if(!curAny.sub.containsKey('.')){
                    WordDictionary nextAny = new WordDictionary();
                    cur.sub.put('.', nextAny);
                    curAny.sub.put('.', nextAny);
                }else{
                    cur.sub.put('.', curAny.sub.get('.'));
                }

            }
            cur = cur.sub.get(c);
            curAny = curAny.sub.get('.');
        }
        cur.isEnd = true;
        curAny.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary cur = this;
        for (char c : word.toCharArray()) {
            if(!cur.sub.containsKey(c)){
                return false;
            }
            cur = cur.sub.get(c);
        }
        return cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
