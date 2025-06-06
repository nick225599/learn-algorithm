package org.nick.learn.leetcode.p3;

public class P3Solution5 {

    // 将官方题解改写成清爽版本
    public int lengthOfLongestSubstring(String s) {
        boolean[] occ = new boolean[128];
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (occ[s.charAt(right)]) {
                occ[s.charAt(left)] = false;
                left++;
            }
            occ[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
