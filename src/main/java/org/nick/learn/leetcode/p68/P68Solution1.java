package org.nick.learn.leetcode.p68;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P68Solution1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> lines = new ArrayList<>();
        int startIndex = -1, endIndex = -1;
        int lineNumber = 1;
        while (endIndex != words.length - 1) {
            startIndex = endIndex + 1;
            // 判断这行能用第几到第几个单词，一共几个单词，几个单词间隙
            int curIdx;
            int lineWidth = 0;
            for (curIdx = startIndex; lineWidth <= maxWidth && curIdx < n; curIdx++) {
                if (lineWidth != 0) {
                    lineWidth += 1;
                }
                String word = words[curIdx];
                int wordLength = word.length();
                lineWidth += wordLength;
            }
            if (lineWidth > maxWidth) {
                endIndex = curIdx - 2;
            } else {
                endIndex = curIdx - 1;
            }
            log.info("第 {} 行，取词范围从 {} 到 {}", lineNumber++, words[startIndex], words[endIndex]);

            // 求出单词间隙为 1 个空格时的行长度
            if (lineWidth > maxWidth) {
                lineWidth -= words[endIndex + 1].length();
                lineWidth -= 1;
            }
            log.info("第 {} 行，单词之间不额外添加空格时的长度 {}", lineNumber, lineWidth);

            // 计算有几个单词间隙，需要补多少个空格，每个间隙需要补多少个
            int wordSpaceNum = endIndex - startIndex;
            int spaceTotalNumToFill = maxWidth - lineWidth;
            int allocatedSpaceNum = (int) Math.ceil((double) spaceTotalNumToFill / wordSpaceNum);
            log.info("第 {} 行，一共有 {} 个单词间隙，需要填充 {} 个空格，平均每个间隙需要填充 {} 个空格",
                    lineNumber, wordSpaceNum, spaceTotalNumToFill, allocatedSpaceNum);

            // 开始拼凑字符串
            StringBuilder sb = new StringBuilder(words[startIndex]);
            for (int i = startIndex + 1; i <= endIndex; i++) {
                sb.append(" ");
                if (endIndex != n - 1) {
                    if (spaceTotalNumToFill > allocatedSpaceNum) {
                        sb.append(" ".repeat(allocatedSpaceNum));
                        spaceTotalNumToFill -= allocatedSpaceNum;
                    } else if (spaceTotalNumToFill > 0) {
                        sb.append(" ".repeat(spaceTotalNumToFill));
                        spaceTotalNumToFill = 0;
                    }
                }
                sb.append(words[i]);
            }

            log.info("第 {} 行 {}", lineNumber, sb.toString());

            log.info("");
        }

        return lines;
    }
}
