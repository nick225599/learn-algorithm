package org.nick.learn.leetcode.p30;

import java.util.ArrayList;
import java.util.List;

public class P30Solution1 {

    List<String> allCombinations = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        // 使用回溯组合 words
        //TODO nick 20250930 菜狗 甚至搞不定一个回溯写法
        this.enumerateAllCombinations(words);

        // 使用 indexOf 记录
        return null;
    }

    // 给定一个字符串数组，怎么列举出所有的排列组合？
    private List<String> enumerateAllCombinations(String[] words) {
        int n = words.length;
        List<String> combination = new ArrayList<>();
        this.enumerateAllCombinations(words, combination);
        return null;
    }

    private void enumerateAllCombinations(String[] words,List<String> combination) {

        if (combination.size() == words.length) {
            StringBuilder sb = new StringBuilder();
            for(String word : combination){
                sb.append(word);
            }
            allCombinations.add(sb.toString());
            return;
        }

        for (String word : words) {
            if (combination.contains(word)) {
                continue;
            }

            // 不采用 i
            this.enumerateAllCombinations(words, combination);

            // 采用 i
            combination.add(word);
            this.enumerateAllCombinations(words, combination);
            combination.remove(word);


        }

    }
}
