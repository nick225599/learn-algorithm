package org.nick.learn.leetcode.p8;

public class Solution1 {
    public static void main(String[] args) {
        String str = ".1";
        System.out.println(new Solution1().myAtoi(str));
    }

    public int myAtoi(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        char c;
        boolean isPositive = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (i == 0) {
                if ('+' == c) {
                    isPositive = true;
                    continue;
                } else if ('-' == c) {
                    isPositive = false;
                    continue;
                } else if (String.valueOf(c).matches("[0123456789]")) {
                    isPositive = true;
                    sb.append(c);
                    continue;
                } else {
                    break;
                }
            }

            if (String.valueOf(c).matches("[0123456789]")) {
                sb.append(c);
            } else {
                break;
            }
        }
        if (sb.isEmpty()) {
            return 0;
        } else {
            try {
                int result = Integer.parseInt(sb.toString());
                if (isPositive) {
                    return result;
                } else {
                    return -result;
                }
            } catch (NumberFormatException e) {
                if (isPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

        }
    }
}
