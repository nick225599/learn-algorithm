package org.nick.learn.leetcode.p211;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class P211Solution2Test {

    @Test
    public void test(){
        P211Solution2.WordDictionary dict = new P211Solution2.WordDictionary();
        dict.addWord("abc");
        assertTrue(dict.search("a.c"));
    }

}