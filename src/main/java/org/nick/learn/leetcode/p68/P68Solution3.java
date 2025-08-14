package org.nick.learn.leetcode.p68;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class P68Solution3 {

    /*
    算法能力的核心是 “解决问题的能力”，而不仅仅是 “掌握经典算法”。
    力扣第 68 题虽然没有复杂的算法模型，但它通过贴近实际的文本排版场景，
    考察了问题拆解、逻辑建模、边界处理、代码结构化等核心工程能力 —— 这些能力是写出可靠、
    可维护代码的基础，也是算法工程师必备的素质。

    在实际开发中，“把简单逻辑写对” 往往比 “实现复杂算法” 更常见，也更能体现编程功底。这正是这类题的价值所在。
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int startIndex = 0;
        while (true) {
            // 计算一行能出放几个单词
            int w = words[startIndex].length();
            int i;

            // 判断第 i 个单词是否可以放入当前行
            int endIndex = startIndex;
            for (i = startIndex + 1; true; i++) {
                // 当前行容不下第 i 个单词了
                if (w + 1 + words[i].length() > maxWidth) {
                    break;
                }

                // 容得下下一个单词
                w = w + 1 + words[i].length();
                endIndex = i;

                // 没容量了，或者没词了，提前结束判断
                if (w >= maxWidth || i >= n - 1) {
                    break;
                }
            }

            String str = this.buildStr(words, n, startIndex, endIndex, maxWidth - w);
            ans.add(str);

            if (endIndex == n - 1) {
                break;
            }

            startIndex = endIndex + 1;
        }
        return ans;
    }

    private String buildStr(String[] words, int n, int startIndex, int endIndex, int remainderWidth) {
        boolean isLastLine = endIndex == n - 1;
        if (isLastLine) {
            return buildLastStr(words, n, startIndex, endIndex, remainderWidth);
        }

        int slotsNum = endIndex - startIndex;

        // 每个插槽需要至少需要补多少个空格
        int x = remainderWidth / slotsNum;
        // 还剩下多少个空格需要平铺到插槽中
        int y = remainderWidth % slotsNum;

        StringBuilder sb = new StringBuilder(words[startIndex]);
        for (int i = startIndex + 1; i <= endIndex; i++) {
            sb.append(" ".repeat(x + 1));
            if (y > 0) {
                sb.append(" ");
                y--;
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private String buildLastStr(String[] words, int n, int startIndex, int endIndex, int remainderWidth) {
        StringBuilder sb = new StringBuilder(words[startIndex]);
        for (int i = startIndex + 1; i <= endIndex; i++) {
            sb.append(" ").append(words[i]);
        }
        sb.append(" ".repeat(remainderWidth));
        return sb.toString();
    }


}
