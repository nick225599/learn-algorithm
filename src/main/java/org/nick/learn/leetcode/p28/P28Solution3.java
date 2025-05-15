package org.nick.learn.leetcode.p28;


public class P28Solution3 {
    // 计算 26 的乘方阶，用于后续快速计算 hash 值
    long MOD = Integer.MAX_VALUE;

    /**
     * RK 算法 + 取模，不再使用 BigDecimal 类，降低对内存的占用
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        if(n < m){
            return -1;
        }

        long[] arr26 = new long[m];
        arr26[0] = 1;
        for (int i = 1; i < m; i++) {
            arr26[i] = (arr26[i - 1] * 26) % MOD;
        }

        long hashN = this.calculateHash(needle, m, arr26);
        long hashH0 = this.calculateHash(haystack, m, arr26);
        if (hashH0 == hashN) {
            return 0;
        }

        long hashHI = hashH0;
        for (int i = 1; i <= n - m; i++) {
            // 计算 i-1 位在上一次计算时的权重
            char char0 = haystack.charAt(i - 1);
            long long0 = charToInt(char0);
            long bitHash0 = long0 * arr26[m - 1];

            // 根据上一次计算的 hash 值，快速计算出当前位的hash值
            char char1 = haystack.charAt(i + m - 1);
            long long1 = charToInt(char1);

            hashHI = (hashHI - bitHash0) * 26 + long1;
            if (hashHI == hashN) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private long calculateHash(String str, int length, long[] arr26) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            char cChar = str.charAt(i);
            long cLong = charToInt(cChar);
            long bitWeight = arr26[length - i - 1];
            long bitHash = cLong * bitWeight;
            hash = (hash + bitHash) % MOD;
        }
        return hash;
    }

    private long charToInt(char c) {
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
