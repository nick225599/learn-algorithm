package org.nick.learn.leetcode.p383;

import java.util.Arrays;

public class P383Solution1 {
    // 自创写法，空间复杂度有点高，时间复杂度也不低，有其他解法吗？
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] charsRandom = ransomNote.toCharArray();
        char[] charsMagazine = magazine.toCharArray();
        Arrays.sort(charsRandom);
        Arrays.sort(charsMagazine);
        int i = 0, j = 0;
        int n = ransomNote.length(), m = magazine.length();
        while (i < n && j < m) {
            if (charsRandom[i] == charsMagazine[j]) {
                i++;
            } else {
                if (charsRandom[i] < charsMagazine[j]) {
                    System.out.println("fast fail");
                    return false;
                }
            }
            j++;
        }
        return i == n;
    }
}
