package org.nick.learn.leetcode.p68;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P68Solution1 {

    // 超出时间限制
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int lastIndex = n - 1;
        int startIndex = 0, endIndex = 0;
        while (endIndex != lastIndex) {
            int i = startIndex;
            int w = words[i].length();
            while (w < maxWidth) {
                if (i == lastIndex) {
                    break;
                }
                if (w + 1 + words[i + 1].length() > maxWidth) {
                    break;
                }
                i++;
                w += (1 + words[i].length());
            }
            endIndex = i;

            // 计算一行能放 x 个单词
            int x = endIndex - startIndex + 1;

            // 计算单词之间要放 y 个空格
            int slotsNum = x - 1;
            int y, remainderWidth;
            if (slotsNum != 0) {
                y = ((maxWidth - w) / slotsNum) + 1;

                // 如果有空格余数，那么每个间隙还得补放 1 个空格
                remainderWidth = (maxWidth - w) % slotsNum;
            } else {
                y = 0;
                remainderWidth = maxWidth - w;
            }

            // 拼凑出这一行
            StringBuilder sb = new StringBuilder();
            for (int k = startIndex; k <= endIndex; k++) {
                if (k != startIndex) {
                    sb.append(" ".repeat(y));
                    if (remainderWidth > 0) {
                        sb.append(" ");
                        remainderWidth--;
                    }
                }
                sb.append(words[k]);
            }
            String curLine = sb.toString();
            ans.add(curLine);

            // 继续下一行
            startIndex = endIndex + 1;
        }
        String str = ans.removeLast();
        str = str.trim();
        ans.add(str);
        return ans;
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
