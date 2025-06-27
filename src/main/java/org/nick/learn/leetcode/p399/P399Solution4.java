package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class P399Solution4 {

    // 带权图  + Floyd 算法

    // 用 double 类型，第 28 个测试案例会出现精度不够的问题，用 BigDecimal 则出现超时，
    // 这题就不是给 Floyd 算法设计的
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count = 0;
        Map<String, Integer> indexOfStrings = new HashMap<>();
        for (List<String> equation : equations) {
            String strA = equation.getFirst();
            if (!indexOfStrings.containsKey(strA)) {
                indexOfStrings.put(strA, count++);
            }

            String strB = equation.getLast();
            if (!indexOfStrings.containsKey(strB)) {
                indexOfStrings.put(strB, count++);
            }
        }

        BigDecimal[][] graph = new BigDecimal[count][count];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String strA = equation.getFirst();
            String strB = equation.getLast();
            int indexA = indexOfStrings.get(strA);
            int indexB = indexOfStrings.get(strB);
            graph[indexA][indexB] = BigDecimal.valueOf(values[i]);
            graph[indexB][indexA] = BigDecimal.ONE.divide(BigDecimal.valueOf(values[i]), RoundingMode.HALF_UP);
        }


        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                for (int z = 0; z < count; z++) {
                    if (graph[y][x] != null && graph[x][z] != null
                            && graph[y][x].compareTo(BigDecimal.ZERO) > 0
                            && graph[x][z].compareTo(BigDecimal.ZERO) > 0) {
                        graph[y][z] = graph[y][x] .multiply(graph[x][z]) ;
                    }
                }
            }
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            String x = query.getFirst();
            String y = query.getLast();
            int indexOfX = indexOfStrings.getOrDefault(x, -1);
            int indexOfY = indexOfStrings.getOrDefault(y, -1);
            double result = -1.0;
            if (indexOfX != -1 && indexOfY != -1) {
                if (graph[indexOfX][indexOfY] != null
                        && graph[indexOfX][indexOfY].compareTo(BigDecimal.ZERO) > 0) {
                    result = graph[indexOfX][indexOfY].doubleValue();
                }
            }
            ret[i] = result;
        }
        return ret;
    }

}
