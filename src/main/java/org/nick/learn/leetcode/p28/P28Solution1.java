package org.nick.learn.leetcode.p28;

public class P28Solution1 {

    /**
     * “needle” 和 “haystack” 常一起出现在 “needle in a haystack” 这个习语中，
     * 从字面意思理解是 “干草堆里的针”，用来形容某事物很难被找到，
     * 因为在一大堆干草中寻找一根针是极其困难的。
     * 所以它们的关系主要是通过这个习语来体现，用于表达寻找某物的难度极大。
     * 例如：Finding my lost keys in this messy room is like looking for a needle in a haystack.
     * （在这个乱糟糟的房间里找我丢失的钥匙就像大海捞针。）
     *
     * BF 算法（Brute Force 暴力匹配算法）
     * 时间复杂度 O((n - m) * m), n = haystack.length, m = needle.length
     * 空间复杂度 O(1)
     *
     * @param haystack 干草堆
     * @param needle 针状物
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean b = needleInHaystack(haystack, needle, i);
                if (b) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean needleInHaystack(String haystack, String needle, int i) {
        for (int j = 1; j < needle.length(); j++) {
            char c1 = haystack.charAt(i + j);
            char c2 = needle.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
