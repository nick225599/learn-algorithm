package org.nick.learn.leetcode.p28;



public class P28Solution2 {

    /**
     * RK 算法的全称叫 Rabin-Karp 算法，
     * 是由它的两位发明者 Rabin 和 Karp 的名字来命名的。
     *
     * 时间复杂度 O(n + m)
     * 空间复杂度 O(m) 预存储长度为 m 的 26 进制的阶
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        java.math.BigDecimal[] arr26 = new java.math.BigDecimal[m];
        arr26[0] = new java.math.BigDecimal(1);
        java.math.BigDecimal tmp = new java.math.BigDecimal(1);
        java.math.BigDecimal bd26 = new java.math.BigDecimal(26);
        for (int i = 1; i < m; i++) {
            tmp = tmp.multiply(bd26);
            arr26[i] = tmp;
        }

        java.math.BigDecimal hashOfNeedle = this.calculateHash(needle, 0, m, arr26);

        java.math.BigDecimal tmpHash = this.calculateHash(haystack, 0, m, arr26);
        if(tmpHash.equals(hashOfNeedle)){
            return 0;
        }
        for(int i = 1; i <= n - m; i++){
            // 计算 i-1 位在上一次计算时的权重
            char c0 = haystack.charAt(i - 1);
            int intC0 = charToInt(c0);
            java.math.BigDecimal bitWeight = arr26[m - 1].multiply(new java.math.BigDecimal(intC0));

            char c1 = haystack.charAt(i + m - 1);
            int intC1 = charToInt(c1);

            tmpHash = tmpHash
                    .subtract(bitWeight)
                    .multiply(new java.math.BigDecimal(26))
                    .add(new java.math.BigDecimal(intC1));

            if(tmpHash.equals(hashOfNeedle)){
                return i;
            }
        }

        return -1;
    }

    private java.math.BigDecimal calculateHash(String str, final int startIndex, final int length, java.math.BigDecimal[] arr26) {
        java.math.BigDecimal hash = new java.math.BigDecimal(0);
        for (int i = 0; i < length; i++) {
            char c = str.charAt(startIndex + i);
            int intC = charToInt(c);
            java.math.BigDecimal bitWeight = arr26[length - i - 1];
            java.math.BigDecimal bitHash = new java.math.BigDecimal(intC).multiply(bitWeight);
            hash = hash.add(bitHash);
        }
        return hash;
    }

    private int charToInt(char c) {
        return switch (c) {
            case 'a' -> 1;
            case 'b' -> 2;
            case 'c' -> 3;
            case 'd' -> 4;
            case 'e' -> 5;
            case 'f' -> 6;
            case 'g' -> 7;
            case 'h' -> 8;
            case 'i' -> 9;
            case 'j' -> 10;
            case 'k' -> 11;
            case 'l' -> 12;
            case 'm' -> 13;
            case 'n' -> 14;
            case 'o' -> 15;
            case 'p' -> 16;
            case 'q' -> 17;
            case 'r' -> 18;
            case 's' -> 19;
            case 't' -> 20;
            case 'u' -> 21;
            case 'v' -> 22;
            case 'w' -> 23;
            case 'x' -> 24;
            case 'y' -> 25;
            case 'z' -> 26;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }


}
