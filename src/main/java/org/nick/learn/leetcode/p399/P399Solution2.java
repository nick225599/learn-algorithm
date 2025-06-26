package org.nick.learn.leetcode.p399;

import java.util.*;

public class P399Solution2 {

    // 图的深度优先 dfs

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建图
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.getFirst();
            String b = equation.getLast();
            double value = values[i];

            Map<String, Double> subMap1 = map.computeIfAbsent(a, k -> new HashMap<>());
            subMap1.put(b, value);

            Map<String, Double> subMap2 = map.computeIfAbsent(b, k -> new HashMap<>());
            subMap2.put(a, 1 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.getFirst();
            String b = query.getLast();
            double result = this.query(1, map, a, b, new HashSet<>());
            results[i] = result;
        }
        return results;
    }

    private double query(double value, Map<String, Map<String, Double>> map, String a, String b, Set<String> skipSet) {
        if (map == null || map.isEmpty() || !map.containsKey(a)) {
            return -1;
        }
        Map<String, Double> aMap = map.get(a);
        if (aMap.containsKey(b)) {
            return value * aMap.get(b);
        } else {
            for (String c : aMap.keySet()) {
                if(skipSet.contains(c)){
                    continue;
                }
                skipSet.add(c);
                double newValue = value * aMap.get(c);
                double result = this.query(newValue, map, c, b, skipSet);
                if (result != -1) {
                    return result;
                }
            }
            return -1;
        }
    }
}
