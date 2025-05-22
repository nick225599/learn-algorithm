package org.nick.learn.leetcode.p125;

public class P125Solution1 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            char charI;
            do {
                if (i >= n) {
                    charI = '&';
                    break;
                }
                charI = s.charAt(i++);
                charI = this.toLowerCase(charI);
            } while (charI < '0' || (charI > '9' && charI < 'a') || charI > 'z');

            char charJ;
            do {
                if (j < 0) {
                    charJ = '&';
                    break;
                }
                charJ = s.charAt(j--);
                charJ = this.toLowerCase(charJ);
            } while (charJ < '0' || (charJ > '9' && charJ < 'a') || charJ > 'z');
            if (charI != charJ) {
                return false;
            }

            // 过半直接终止循环
            if (i > j) {
                return true;
            }
        }
        return true;
    }

    private char toLowerCase(char charI) {
        if (charI >= 'A' && charI <= 'Z') {
            charI = (char) (charI + ('a' - 'A'));
        }
        return charI;
    }

    public static void main(String[] args) {

        System.out.println((int) 'a'); // 97
        System.out.println((int) 'z'); // 122
        System.out.println((int) 'A'); // 65
        System.out.println((int) 'Z'); // 90
        System.out.println((int) '0'); // 48
        System.out.println((int) '1'); // 49
        System.out.println((int) '2'); // 50
        System.out.println((int) '9'); // 57
    }
}
