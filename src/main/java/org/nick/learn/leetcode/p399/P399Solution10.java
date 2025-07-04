package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

// 力扣第 399 题
@Slf4j
public class P399Solution10 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] res = new double[n];
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            String divisor = e.get(0);
            String divend = e.get(1);
            double num = values[i];
            if (!map.containsKey(divisor)) {
                map.put(divisor, new HashMap<>());
            }
            if (!map.containsKey(divend)) {
                map.put(divend, new HashMap<>());
            }
            map.get(divisor).put(divend, num);
            map.get(divend).put(divisor, 1.0 / num);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String divisor = q.get(0);
            String divend = q.get(1);
            res[i] = dfs(divisor, divend, map, values, new HashSet<>());
        }
        return res;
    }

    private double dfs(String divisor, String divend, Map<String, Map<String, Double>> map, double[] values, Set<String> visited) {
        if (!map.containsKey(divisor)) {
            return -1.0;
        }
        if (divisor.equals(divend)) {
            return 1.0;
        }
        if (map.get(divisor).containsKey(divend)) {
            return map.get(divisor).get(divend);
        }
        visited.add(divisor);
        for (String neighbor : map.get(divisor).keySet()) {
            if (visited.contains(neighbor)) {
                continue;
            }
            double base = map.get(divisor).get(neighbor);
            double qut = dfs(neighbor, divend, map, values, visited);
            if (qut >= 0.0) {
                return base * qut;
            }
        }
        return -1.0;
    }


}
