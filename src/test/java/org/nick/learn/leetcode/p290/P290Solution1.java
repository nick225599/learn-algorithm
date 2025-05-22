package org.nick.learn.leetcode.p290;

import java.util.HashMap;
import java.util.Map;

public class P290Solution1 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        Map<Character, String> c2s = new HashMap<>(pattern.length());
        Map<String, Character> s2c = new HashMap<>(strings.length);
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strings[i];

            String tmpS = c2s.get(c);
            if (null == tmpS) {
                c2s.put(c, str);
            } else if (!tmpS.equals(str)) {
                return false;
            }

            Character tmpC = s2c.get(str);
            if (null == tmpC) {
                s2c.put(str, c);
            } else if (tmpC != c) {
                return false;
            }
        }
        return true;
    }
}
