package org.nick.learn.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class P3Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> charSet = new HashSet<>();
        int n = s.length();

        int left = 0;
        int right = 0;
        int maxLength = 1;
        while (right < n) {
            while (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                right++;
                if (right == n) {
                    return Math.max(maxLength, right - left);
                }
            }
            maxLength = Math.max(maxLength, right - left);

            // 删除 [left, right] 之中，跟 s[right] 相同的字符左边的字符及其本身
            while(!charSet.remove(s.charAt(left++))){}
        }
        return maxLength;
    }
}
