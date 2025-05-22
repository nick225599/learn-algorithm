package org.nick.learn.leetcode.p383;

public class P383Solution2 {
    // 字符统计
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[][] chars = new int[256][2];
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i)][0]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i)][1]++;
        }
        for (int i = 0; i < 256; i++) {
            if (chars[i][0] > chars[i][1]) {
                return false;
            }
        }
        return true;
    }
}
