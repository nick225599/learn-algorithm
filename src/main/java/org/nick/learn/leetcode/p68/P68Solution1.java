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
                if(lineWidth != 0){
                    lineWidth += 1;
                }
                String word = words[curIdx];
                int wordLength = word.length();
                lineWidth += wordLength;
                log.info("cur word: {}, word length: {}, line width: {}", word, wordLength, lineWidth);
            }
            endIndex = curIdx - 1;
            log.info("第 {} 行，开始单词 {}, 结束单词 {}", lineNumber, words[startIndex], words[endIndex]);
        }

        return lines;
    }
}
