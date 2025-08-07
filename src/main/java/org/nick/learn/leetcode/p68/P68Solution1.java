package org.nick.learn.leetcode.p68;

import java.util.ArrayList;
import java.util.List;

public class P68Solution1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int usedIndex = -1;
        while (usedIndex < words.length - 1) {
            // 判断一行能用第几到第几个 words
            int startIndex = usedIndex + 1;
            int curIndex = startIndex;
            int endIndex;
            int width = 0;
            while (width <= maxWidth && curIndex < words.length) {
                if (width != 0) {
                    width += 1;
                }
                width += words[curIndex].length();
                curIndex++;
            }
            width -= words[curIndex - 1].length();
            endIndex = curIndex - 2;
            usedIndex = endIndex;

            int left = maxWidth - width;
            int n = endIndex - startIndex + 1;
            int everySpaceNumber = (int) Math.ceil((double) left / n);

            StringBuilder sb = new StringBuilder();
            for (int i = startIndex; i <= endIndex; i++) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                if (left > everySpaceNumber) {
                    sb.append(" ".repeat(everySpaceNumber));
                    left -= everySpaceNumber;
                } else if (left > 0) {
                    sb.append(" ".repeat(left));
                    left = 0;
                }
                sb.append(words[0]);
            }
            lines.add(sb.toString());
            System.out.println("used index: " + usedIndex);
        }

        return lines;
    }
}
