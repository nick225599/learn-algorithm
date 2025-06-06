package org.nick.learn.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class P3Solution1 {
    public int lengthOfLongestSubstring(String s) {
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

//        int n = s.length();
//
//        Set<Character> charSet = new HashSet<>();
//        int i = 0;
//        charSet.add(s.charAt(i));
//        int j = 1;
//        int length = 1;
//        int maxLength = 1;
//        while (j < n) {
//            boolean b = charSet.add(s.charAt(j));
//            if (b) {
//                length++;
//                maxLength = Math.max(maxLength, length);
//                j++;
//            } else {
//                while(s.charAt(i) != s.charAt(j)){
//                    charSet.remove(s.charAt(i));
//                    i++;
//                    length--;
//                }
//                charSet.remove(s.charAt(i));
//                i++;
//                length--;
////                do {
////                    charSet.remove(s.charAt(i));
////                    length--;
////                    i++;
////                } while (s.charAt(i - 1) != s.charAt(j));
//            }
//
//        }
//        return maxLength;
    }
}
