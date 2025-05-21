package org.nick.learn.common.util;

import java.util.Random;

public class StringUtils {
    private StringUtils() {
    }

    public static String generateRandomStr(int length) {
        char[] chars = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) ((r.nextInt(100)  % 26 + (int) 'a'));
            chars[i] = c;
        }
        return new String(chars);
    }

}
