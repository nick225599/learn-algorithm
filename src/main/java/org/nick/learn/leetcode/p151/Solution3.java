package org.nick.learn.leetcode.p151;

import java.util.*;

public class Solution3 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split("\\s+");
        List<String> stringList = new LinkedList<>(Arrays.asList(strings));
        Collections.reverse(stringList);
        String result = String.join(" ", stringList);
        return result;
    }
}
