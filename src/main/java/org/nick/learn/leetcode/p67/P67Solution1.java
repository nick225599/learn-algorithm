package org.nick.learn.leetcode.p67;

public class P67Solution1 {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int maxLength = Math.max(n, m);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxLength; i++) {
            int bitA = 0;
            if (n - 1 - i >= 0) {
                bitA = '0' == a.charAt(n - 1 - i) ? 0 : 1;
            }
            int bitB = 0;
            if (m - 1 - i >= 0) {
                bitB = '0' == b.charAt(m - 1 - i) ? 0 : 1;
            }
            int tmp = bitA + bitB + carry;
            switch (tmp) {
                case 0:
                case 1:
                    if (i == maxLength && tmp == 0) {
                        break;
                    }
                    sb.insert(0, tmp);
                    carry = 0;
                    break;
                case 2:
                    sb.insert(0, 0);
                    carry = 1;
                    break;
                case 3:
                    sb.insert(0, 1);
                    carry = 1;
                    break;
            }
        }
        return sb.toString();
    }
}
