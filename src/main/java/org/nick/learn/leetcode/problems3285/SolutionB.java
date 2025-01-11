package org.nick.learn.leetcode.problems3285;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
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


    public static void main(String[] args) {
        SolutionB solution = new SolutionB();
        int[] mountains;
        List<Integer> indicesOfStableMountains;

        mountains = new int[]{1, 2, 3, 4, 5};
        indicesOfStableMountains = solution.stableMountains(mountains, 2);
        Assert.assertEquals(2, indicesOfStableMountains.size());
        Assert.assertTrue(indicesOfStableMountains.contains(3));
        Assert.assertTrue(indicesOfStableMountains.contains(4));

        mountains = new int[]{10, 1, 10, 1, 10};
        indicesOfStableMountains = solution.stableMountains(mountains, 3);
        Assert.assertEquals(2, indicesOfStableMountains.size());
        Assert.assertTrue(indicesOfStableMountains.contains(1));
        Assert.assertTrue(indicesOfStableMountains.contains(3));

        indicesOfStableMountains = solution.stableMountains(mountains, 10);
        Assert.assertEquals(0, indicesOfStableMountains.size());
    }
}