package org.nick.learn.leetcode.problem3285;



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


}