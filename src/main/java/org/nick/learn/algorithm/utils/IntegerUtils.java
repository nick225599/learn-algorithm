package org.nick.learn.algorithm.utils;

public class IntegerUtils {
    public static String toBinaryString(int x, int fixedLength){
        return String.format("%32s", Integer.toBinaryString(x)).replaceAll(" ", "0");
    }

    public static String toBinaryString32(int x){
        return toBinaryString(x, 32);
    }
}
