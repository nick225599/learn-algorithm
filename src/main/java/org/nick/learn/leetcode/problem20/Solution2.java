package org.nick.learn.leetcode.problem20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        // 用 LinkedList 或 ArrayDeque 都可以
        Deque<Character> characterDeque = new LinkedList<>();
//        Deque<Character> characterDeque = new ArrayDeque<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('{' == c || '[' == c || '(' == c) {
                boolean b = characterDeque.offerFirst(c);
                if (!b) {
                    return false;
                }
            }
            boolean b = true;
            if ('}' == c) {
                b = Character.valueOf('{').equals(characterDeque.pollFirst());
            }
            if (']' == c) {
                b = Character.valueOf('[').equals(characterDeque.pollFirst());
            }
            if (')' == c) {
                b = Character.valueOf('(').equals(characterDeque.pollFirst());
            }
            if (!b) {
                return false;
            }
        }
        return characterDeque.isEmpty();
    }
}
