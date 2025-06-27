package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class P399Solution7 {

    // 带权并查集
    // AI 生成的非路径压缩 非惰性计算的版本
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // 构建变量到整数ID的映射
        Map<String, Integer> varToId = new HashMap<>();
        int id = 0;
        for (List<String> eq : equations) {
            String a = eq.get(0), b = eq.get(1);
            if (!varToId.containsKey(a)) varToId.put(a, id++);
            if (!varToId.containsKey(b)) varToId.put(b, id++);
        }

        // 初始化并查集数据结构
        int size = varToId.size();
        int[] parent = new int[size];    // 父节点数组
        double[] weight = new double[size]; // 当前节点到父节点的权重
        for (int i = 0; i < size; i++) {
            parent[i] = i;       // 初始时父节点是自己
            weight[i] = 1.0;     // 自己到自己的权重为1
        }

        // 处理所有等式，合并集合
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0), b = eq.get(1);
            int x = varToId.get(a), y = varToId.get(b);
            double val = values[i];
            union(parent, weight, x, y, val);
        }

        // 处理所有查询
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0), b = query.get(1);

            // 若变量不存在，直接返回-1
            if (!varToId.containsKey(a) || !varToId.containsKey(b)) {
                result[i] = -1.0;
                continue;
            }

            int x = varToId.get(a), y = varToId.get(b);
            int rootX = find(parent, x);
            int rootY = find(parent, y);

            // 若不连通，返回-1
            if (rootX != rootY) {
                result[i] = -1.0;
            } else {
                // 计算a/b的值：a到根的权重除以b到根的权重
                double valX = getWeightToRoot(parent, weight, x);
                double valY = getWeightToRoot(parent, weight, y);
                result[i] = valX / valY;
            }
        }

        return result;
    }

    // 合并操作：将x和y所在集合合并
    private void union(int[] parent, double[] weight, int x, int y, double val) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        // 若已连通，直接返回
        if (rootX == rootY) return;

        // 将rootX的父节点设为rootY
        parent[rootX] = rootY;
        // 计算rootX到rootY的权重：(x到rootX的权重 * val) / y到rootY的权重
        weight[rootX] = getWeightToRoot(parent, weight, x) * val / getWeightToRoot(parent, weight, y);
    }

    // 查找操作：返回x的根节点
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // 计算x到根节点的权重
    private double getWeightToRoot(int[] parent, double[] weight, int x) {
        double res = 1.0;
        while (parent[x] != x) {
            res *= weight[x];
            x = parent[x];
        }
        return res;
    }

}
