package org.nick.learn.leetcode.p211;

public class P211Solution1 {

}

class WordDictionary {
    public WordDictionary[] sub;
    public boolean isEnd;

    public WordDictionary() {
        sub = new WordDictionary[27];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        WordDictionary curAny = this;
        for (char c : word.toCharArray()) {
            if (cur.sub[c - 'a'] == null) {
                cur.sub[c - 'a'] = curAny.sub[c - 'a'] = new WordDictionary();
                cur.sub[26] = curAny.sub[26] = new WordDictionary();
            }
            cur = cur.sub[c - 'a'];
            curAny = curAny.sub[26];
        }
        cur.isEnd = true;
        curAny.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary cur = this;
        for (char c : word.toCharArray()) {
            if (c == '.') {
                if (cur.sub[26] != null) {
                    cur = cur.sub[26];
                } else {
                    return false;
                }
            } else if (cur.sub[c - 'a'] != null) {
                cur = cur.sub[c - 'a'];
            } else {
                return false;
            }
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
