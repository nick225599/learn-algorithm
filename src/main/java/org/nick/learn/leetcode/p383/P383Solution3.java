package org.nick.learn.leetcode.p383;

public class P383Solution3 {
    // 字符统计，快速失败
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i)]--;
            // 快速失败
            if (chars[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
