package org.nick.learn.leetcode.p68;

import org.junit.jupiter.api.Test;

import java.util.List;

class P68Solution3Test {

    P68Solution3 solution = new P68Solution3();

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

    @Test
    void fullJustify2() {
        // words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> lines = solution.fullJustify(words, maxWidth);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}