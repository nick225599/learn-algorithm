package org.nick.learn.leetcode.p30;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class P30Solution1 {
    static class Solution {

        // 第 179 个测试案例超时，多线程依旧超时
        public List<Integer> findSubstring(String s, String[] words) {
            try {
                int wLength = words[0].length();
                int sLength = wLength * words.length;
                if (s.length() < sLength) {
                    return new ArrayList<>();
                }

                int endIndex = s.length() - sLength;
                List<Future<Integer>> futures = new ArrayList<>(endIndex);
                List<Integer> result = new ArrayList<>();
                try (ExecutorService executorService = Executors.newCachedThreadPool()) {
                    for (int i = 0; i <= endIndex; i++) {
                        int finalI = i;
                        Future<Integer> future = executorService.submit(new Callable<Integer>() {
                            @Override
                            public Integer call() throws Exception {
                                return callA(finalI, sLength, words, s);
                            }
                        });
                        futures.add(future);
                    }
                    executorService.shutdown();
                    executorService.awaitTermination(1, TimeUnit.MINUTES);

                    for (Future<Integer> future : futures) {
                        Integer integer = future.get(100, TimeUnit.MICROSECONDS);
                        if (null != integer) {
                            result.add(integer);
                        }
                    }
                    return result;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();
            }

            // 从 s 的第 0 个位置开始，一直到第 s.length() - words[0].length() * words.size()
            // 判断每 word[0].length() 个字符，判断是否属于 words, 属于的话标记已使用

        }

        private static Integer callA(final int finalI, int sLength, String[] words, String s) {
            // 判断字符串 s 的 index: i, length: wLength 的子字符串，是否包含所有 words
            int startIndex = finalI;
            int endIndex = startIndex + sLength; // exclude
            boolean[] used = new boolean[words.length];
            while (startIndex < endIndex) {
                boolean containAWord = Solution.containAWorld(s, startIndex, words, used);
                if (containAWord) {
                    startIndex += words[0].length();
                } else {
                    return null;
                }
            }
            return finalI;
        }

        private static boolean containAWorld(String s, int index, String[] words, boolean[] used) {
            for (int i = 0; i < words.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (strEquals(s, index, words[i])) {
                    used[i] = true;
                    return true;
                }
            }
            return false;
        }

        private static boolean strEquals(String s, int index, String word) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(index + i)) {
                    return false;
                }
            }
            return true;
        }

    }

}
