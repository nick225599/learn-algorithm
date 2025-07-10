package org.nick.learn.leetcode.p211;

public class P211Solution4 {


    //    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure/solutions/1053383/tian-jia-yu-sou-suo-dan-ci-shu-ju-jie-go-n4ud/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    // 194ms
    static class WordDictionary {
        WordDictionary[] dict;
        boolean isEnd;

        public WordDictionary() {
            this.dict = new WordDictionary[26];
            this.isEnd = false;
        }

        public void addWord(String word) {
            WordDictionary cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.dict[index] == null) {
                    cur.dict[index] = new WordDictionary();
                }
                cur = cur.dict[index];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            return this.search(word, 0, this);
        }

        private boolean search(String word, int index, WordDictionary node) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (WordDictionary subNode : node.dict) {
                        if (subNode != null && this.search(word, i + 1, subNode)) {
                            return true;
                        }
                    }
                    return false;
                } else if (node.dict[c - 'a'] == null) {
                    return false;
                } else {
                    node = node.dict[c - 'a'];
                }
            }
            return node.isEnd;
        }
    }
}


