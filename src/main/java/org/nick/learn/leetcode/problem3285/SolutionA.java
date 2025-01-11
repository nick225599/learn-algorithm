package org.nick.learn.leetcode.problem3285;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SolutionA {

    // 贪心，分治，回溯，动态规划
    public List<Integer> stableMountains(int[] height, int threshold) {
        try {
            ExecutorService es = Executors.newCachedThreadPool();
            List<Future<Integer>> futures = new ArrayList<>();
            for (int i = 1; i < height.length; i++) {
                final int tempI = i;
                Future<Integer> feature = es.submit(() -> {
                    if (height[tempI - 1] > threshold) {
                        return tempI;
                    } else {
                        return null;
                    }
                });
                futures.add(feature);
            }
            es.shutdown();
            es.awaitTermination(3, TimeUnit.MINUTES);
            List<Integer> resultList = new ArrayList<>();
            Integer result;
            for (Future<Integer> f : futures) {
                result = f.get(100, TimeUnit.MILLISECONDS);
                if (null != result) {
                    resultList.add(result);
                }
            }

            return resultList;
        } catch (Exception ignored) {
            return null;
        }
    }


    public static void main(String[] args) {
        SolutionA solution = new SolutionA();
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