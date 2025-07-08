package org.nick.learn.leetcode.p208;

import java.util.HashMap;
import java.util.Map;

public class P208Solution1 {
    static class Trie {
        private Node root;

        static class Node {
            char c;
            public boolean isEndNode = false;
            Map<Character, Node> subNodes;

            public Node(char c) {
                this.c = c;
                this.subNodes = new HashMap<>(26);
            }
        }

        public Trie() {
            root = new Node('/');
        }

        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!cur.subNodes.containsKey(c)) {
                    cur.subNodes.put(c, new Node(c));
                }
                cur = cur.subNodes.get(c);
            }
            cur.isEndNode = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.subNodes.containsKey(c)) {
                    cur = cur.subNodes.get(c);
                } else {
                    return false;
                }

            }
            return cur.isEndNode;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.subNodes.containsKey(c)) {
                    cur = cur.subNodes.get(c);
                } else {
                    return false;
                }

            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
