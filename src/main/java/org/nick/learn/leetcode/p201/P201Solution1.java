package org.nick.learn.leetcode.p201;

public class P201Solution1 {

    //  9:  1001
    // 10:  1010
    // 11:  1011
    // 12:  1100
    // 13:  1101
    // 14:  1110
    // 15:  1111
    // 16: 10000
    // 朴素解法，会超出时间限制
    public int rangeBitwiseAnd(int left, int right) {
        System.out.println("left: " + left);
        System.out.println("binary left: " + Integer.toBinaryString(left));
        System.out.println();
        int ans = left;
        for (int i = left + 1; i <= right; i++) {
            ans &= i;

            System.out.println("i: " + i);
            System.out.println("binary i: " + Integer.toBinaryString(i));
            System.out.println();

            System.out.println("ans: " + ans);
            System.out.println("binary ans: " + Integer.toBinaryString(ans));
            System.out.println();

            System.out.println();


            if(i == Integer.MAX_VALUE){
                break;
            }
        }
        return ans;
    }
}
