package org.nick.learn.leetcode.p12;

public class P12Solution1 {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int thousands = num / 1000;
        int hundreds = (num - 1000 * thousands) / 100;
        int tens = (num - 1000 * thousands - 100 * hundreds) / 10;
        int units = num - 1000 * thousands - 100 * hundreds - 10 * tens;

        // 3000 MMM
        // 2000 MM
        // 1000 M
        result.append("M".repeat(thousands));

        // 900  CM
        // 800  DCCC
        // 700  DCC
        // 600  DC
        // 500  D
        // 400  CD
        // 300  CCC
        // 200  CC
        // 100  C
        if (hundreds == 9) {
            result.append("CM");
        } else if (hundreds >= 5) {
            result.append("D");
            result.append("C".repeat(hundreds - 5));
        } else if (hundreds == 4) {
            result.append("CD");
        } else if (hundreds > 0) {
            result.append("C".repeat(hundreds));
        }


        // 90   XC
        // 80   LXXX
        // 70   LXX
        // 60   LX
        // 50   L
        // 40   XL
        // 30   XXX
        // 20   XX
        // 10   X
        if (tens == 9) {
            result.append("XC");
        } else if (tens >= 5) {
            result.append("L");
            result.append("X".repeat(tens - 5));
        } else if (tens == 4) {
            result.append("XL");
        } else if (tens > 0) {
            result.append("X".repeat(tens));
        }

        // 9    IX
        // 8    VIII
        // 7    VII
        // 6    VI
        // 5    V
        // 4    IV
        // 3    III
        // 2    II
        // 1    I
        if (units == 9) {
            result.append("IX");
        } else if (units >= 5) {
            result.append("V");
            result.append("I".repeat(units - 5));
        } else if (units == 4) {
            result.append("IV");
        } else if (units > 0) {
            result.append("I".repeat(units));
        }
//        int tmp = num / 1000;
//        for(int i = 0; i < tmp; i++){
//            result.append("M");
//        }
//        num = num - tmp * 1000;
//        tmp = num / 100;
//        if(tmp == 4){
//            result.append("CD");
//        }else if(tmp == 9){
//            result.append("CM");
//        }else{
//            for(int i = 0; i < tmp; i++){
//
//            }
//        }
        return result.toString();
    }
}
