package org.nick.learn.leetcode.p30;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
class P30Solution1Test {
    P30Solution1 solution = new P30Solution1();

    @Test
    void findSubstring() throws Exception {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        List<Integer> list = solution.findSubstring(s, words);
        log.info("res: {}", Arrays.toString(list.toArray()));
    }

}