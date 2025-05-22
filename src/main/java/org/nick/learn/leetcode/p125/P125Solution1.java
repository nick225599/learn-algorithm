package org.nick.learn.leetcode.p125;

public class P125Solution1 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = 0;
        while (i + j < s.length() - 2) {
            int intI = 0;
            while (intI < 'a' || intI > 'z') {
                intI = s.charAt(i);
                if ('A' <= intI && intI <= 'Z') {
                    intI = intI + ('a' - 'Z');
                }
                i++;
            }
            int intJ = 0;
            while (intJ < 'a' || intJ > 'z') {
                intJ = s.charAt(n - 1 - j);
                if ('A' <= intJ && intJ <= 'Z') {
                    intJ = intJ + ('a' - 'Z');
                }
                j++;
            }
            if (intI != intJ) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a'); // 97
        System.out.println((int) 'z'); // 122
        System.out.println((int) 'A'); // 65
        System.out.println((int) 'Z'); // 90
        System.out.println(122 - 97);
        System.out.println(90 - 65);
    }
}
