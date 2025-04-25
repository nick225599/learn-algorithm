package org.nick.learn.leetcode.p3285;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionB {

    // 并发，数据量太小，不如单线程
    public List<Integer> stableMountains(int[] height, int threshold) {
        return IntStream.range(1, height.length)
                .parallel()
                .filter(i -> height[i - 1]> threshold)
                .boxed()
                .collect(Collectors.toList());
    }



}