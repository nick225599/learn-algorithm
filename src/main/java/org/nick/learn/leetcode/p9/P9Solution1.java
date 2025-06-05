package org.nick.learn.leetcode.p9;

public class P9Solution1 {
    // 不进阶，一遍过
    // 进阶：你能不将整数转为字符串来解决这个问题吗？
    public boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        for(int i = 0; i < strX.length() >> 1; i++){
            if(strX.charAt(i) != strX.charAt(strX.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
