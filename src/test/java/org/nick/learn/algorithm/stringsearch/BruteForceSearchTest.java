package org.nick.learn.algorithm.stringsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class BruteForceSearchTest {

    @Test
    void searchStr() {
        String mainStr = "abcdd";
        org.junit.jupiter.api.Assertions.assertEquals(0, BruteForceSearch.searchStr(mainStr, "abc"));
        org.junit.jupiter.api.Assertions.assertEquals(1, BruteForceSearch.searchStr(mainStr, "bcd"));
        org.junit.jupiter.api.Assertions.assertEquals(-1, BruteForceSearch.searchStr(mainStr, "foo"));
        log.info("abcdd search d: {}", BruteForceSearch.searchStr(mainStr, "d"));
        log.info("abcdd search d: {}", BruteForceSearch.searchStr(mainStr, "dd"));
    }
}