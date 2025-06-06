package org.nick.learn.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class P3Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Set<Character> charSet = new HashSet<>();
        int n = s.length();

        int left = 0;
        int right = 0;
        int maxLength = 1;
        while (right < n) {
            char c = s.charAt(right);
            boolean addSuccess = charSet.add(c);
            if (addSuccess) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                while (!charSet.remove(s.charAt(left++))) {}
            }
        }
        return maxLength;
    }
}
