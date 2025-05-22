package org.nick.learn.leetcode.p205;

public class P205Solution1 {
    // 自创解法，也不知道叫啥名字
    // 时间复杂度 O(n)
    // 空间复杂度 O(|S|), |S|字符集大小
    public boolean isIsomorphic(String s, String t) {
        int[][] mapping = new int[255][2];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapping[cs][0] == 0) {
                mapping[cs][0] = cs - ct + 1;
            } else if (mapping[cs][0] != cs - ct + 1) {
                return false;
            }
            if (mapping[ct][1] == 0) {
                mapping[ct][1] = cs - ct + 1;
            } else if (mapping[ct][1] != cs - ct + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 256; i++) {
            System.out.println("i: " + i + ", char: " + (char) i);
        }
    }
}
