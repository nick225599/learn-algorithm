package org.nick.learn.leetcode.p68;

import org.junit.jupiter.api.Test;

import java.util.List;

class P68Solution1Test {
    P68Solution1 solution = new P68Solution1();

    @Test
    void fullJustify() {
        // words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> lines = solution.fullJustify(words, maxWidth);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}