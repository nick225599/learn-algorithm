package org.nick.learn.leetcode.p399;

import java.util.*;

public class P399Solution3 {

    record Node(String destination, Double weight) {
    }

    // 用 Map<String, List<Node>> 来构建邻接表（Adjacency List）
    // 用 BFS 来遍历图
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer> str2index = new HashMap<>();
        int index = 0;

        // 邻接表
        Map<String, List<Node>> nodeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.getFirst();
            String b = equation.getLast();
            double weight = values[i];
            List<Node> list;
            list = nodeMap.computeIfAbsent(a, k -> new ArrayList<>());
            list.add(new Node(b, weight));
            list = nodeMap.computeIfAbsent(b, k -> new ArrayList<>());
            list.add(new Node(a, 1 / weight));

            if (!str2index.containsKey(a)) {
                str2index.put(a, index++);
            }
            if (!str2index.containsKey(b)) {
                str2index.put(b, index++);
            }
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.getFirst();
            String y = query.getLast();

            if (nodeMap.get(x) == null || nodeMap.get(y) == null) {
                results[i] = -1;
                continue;
            }

            if (x.equals(y)) {
                results[i] = 1;
                continue;
            }

            double[] tmp = new double[index];
            Arrays.fill(tmp, -1);
            tmp[str2index.get(x)] = 1;

            Queue<String> queue = new ArrayDeque<>();
            queue.add(x);

            while (!queue.isEmpty() && tmp[str2index.get(y)] == -1) {
                String m = queue.remove();
                List<Node> nodeList = nodeMap.get(m);
                for (Node node : nodeList) {
                    String n = node.destination;
                    double d = node.weight;
                    if (tmp[str2index.get(n)] != -1) {
                        continue;
                    }
                    tmp[str2index.get(n)] = tmp[str2index.get(m)] * d;
                    queue.add(n);
                }
            }

            results[i] = tmp[str2index.get(y)];
        }
        return results;
    }

}
