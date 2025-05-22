package org.nick.learn.leetcode.p329;

public class P329Solution1 {
    // 判断 s 是否为 t 的子序列。
    public boolean isSubsequence(String sub, String str) {
        if (sub.length() > str.length()) {
            return false;
        }
        int j = 0;
        int i;
        for (i = 0; i < sub.length(); i++) {
            char cTarget = sub.charAt(i);

            char c;
            do {
                if(j == str.length()){
                    return false;
                }
                c = str.charAt(j++);
            } while (c != cTarget);

        }
        return i == sub.length();

    }
//        if(t.length() < s.length()) return false;
//        int i;
//        int j = 0;
//        for (i = 0; i < s.length(); i++) {
//            char charS, charT;
//            do {
//                charT = s.charAt(i);
//                charS = t.charAt(j++);
//            } while (charS != charT && j < t.length());
//        }
//        return i == s.length();

    public static void main(String[] args) {
        String s = "b";
        String t = "c";
        System.out.println(new P329Solution1().isSubsequence(s, t));
    }
}
