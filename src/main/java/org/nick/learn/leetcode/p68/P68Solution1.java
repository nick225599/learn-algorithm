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

            // 求出单词间隙为 1 个空格时的行长度
            if (lineWidth > maxWidth) {
                lineWidth -= words[endIndex + 1].length();
                lineWidth -= 1;
            }

            // 计算有几个单词间隙，需要补多少个空格，每个间隙需要补多少个
            int wordSpaceNum = endIndex - startIndex;
            int spaceTotalNumToFill = maxWidth - lineWidth;
            int allocatedSpaceNum = wordSpaceNum == 0 ? spaceTotalNumToFill
                    : (int) Math.ceil((double) spaceTotalNumToFill / wordSpaceNum);

            // 开始拼凑字符串
            StringBuilder sb = new StringBuilder();
            for (int i = startIndex; i <= endIndex; i++) {
                if (i != startIndex) {
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
                }
                sb.append(words[i]);
                if (i == endIndex) {
                    sb.append(" ".repeat(spaceTotalNumToFill));
                }

            }
            lines.add(sb.toString());
            lineNumber++;
        }

        return lines;
    }

    /*
    输出
    [
        "Give  me  my  Romeo; and,",
        "when  he  shall die, Take",
        "him  and  cut  him out in",
        "little stars, And he will",
        "make  the  face of heaven",
        "so   fine   That  all the", 3, 3, 2, 1
        "world  will  be  in  love",
        "with  night  And  pay  no",
        "worship   to   the garish",
        "sun.                     "
    ]

    真特么无语，凭啥上面就是错的？

    预期
    [
        "Give  me  my  Romeo; and,",
        "when  he  shall die, Take",
        "him  and  cut  him out in",
        "little stars, And he will",
        "make  the  face of heaven",
        "so   fine  That  all  the", 3, 2, 2, 2
        "world  will  be  in  love",
        "with  night  And  pay  no",
        "worship   to  the  garish",
        "sun.                     "
    ]
    */
}
