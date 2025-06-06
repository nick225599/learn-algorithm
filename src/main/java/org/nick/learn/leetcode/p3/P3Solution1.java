package org.nick.learn.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class P3Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> charSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int length = 0;
        int maxLength = 0;
        while (j < n) {
            boolean b = charSet.add(s.charAt(j));
            if (b) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                do {
                    charSet.remove(s.charAt(i));
                    length--;
                    i++;
                } while (s.charAt(i - 1) != s.charAt(j));
            }
            j++;
        }
        return maxLength;
    }
}
