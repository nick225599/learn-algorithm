package org.nick.learn.leetcode.p13;

public class P13Solution1 {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ci = this.charToInt(c);
            ans += ci;
            if (i > 0) {
                char preC = s.charAt(i - 1);
                int preCI = this.charToInt(preC);
                if(preCI < ci){
                    ans -= preCI;
                    ans -= preCI;
                }
            }
        }
        return ans;
    }

    private int charToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException();
        };
    }
}
