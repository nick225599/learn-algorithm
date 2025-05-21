package org.nick.learn.leetcode.p66;

public class P66Solution1 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n + 1];
        System.arraycopy(digits, 0, result, 1, n);
        result[n]++;
        for(int i = n; i > 0; i--){
            if(result[i] >= 10){
                result[i] = result[i]%10;
                result[i - 1]++;
            }
        }

        if(result[0] == 0){
            int[] newResult = new int[n];
            System.arraycopy(result, 1, newResult, 0, n);
            return newResult;
        }
        return result;
    }
}
