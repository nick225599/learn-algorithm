package org.nick.learn.leetcode.p202;

import java.util.HashSet;

public class P202Solution3 {

    // 快慢指针法
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            if (n == 1) {
                return true;
            }
            n = powSelf(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

//    private int powSelf(int n) {
//        System.out.println("before, n: " + n);
//        String str = String.valueOf(n);
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char tmpC = str.charAt(i);
//            String tmpStr = String.valueOf(tmpC);
//            int tmpInt = Integer.parseInt(tmpStr);
//            sum += (int) Math.pow(tmpInt, 2);
//        }
//        System.out.println("after, sum: " + sum);
//        System.out.println();
//        return sum;
//    }

    private int powSelf(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += (d * d);
            n = n / 10;
        }
        return sum;
    }


    public static void main(String[] args) {

        int i = 1024;
        System.out.println(i % 10);
        System.out.println(i / 10);
    }
}
