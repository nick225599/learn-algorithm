package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 力扣第 399 题
@Slf4j
public class P399Solution15 {

    // 带权并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> roots = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);

            String a = equation.getFirst();
            roots.putIfAbsent(a, a);
            weights.putIfAbsent(a, 1.0);

            String b = equation.getLast();
            roots.putIfAbsent(b, b);
            weights.putIfAbsent(b, 1.0);
        }

        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String a = equation.getFirst();
            String b = equation.getLast();
            Double quotient = values[i];
            this.union(roots, weights, a, b, quotient);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < results.length; i++) {
            List<String> query = queries.get(i);
            String x = query.getFirst();
            String y = query.getLast();
            if (!roots.containsKey(x) || !roots.containsKey(y)) {
                results[i] = -1;
                continue;
            }
            String rootOfX = find(roots, weights, x);
            String rootOfY = find(roots, weights, y);
            if (!rootOfX.equals(rootOfY)) {
                results[i] = -1;
                continue;
            }
            results[i] = weights.get(x) / weights.get(y);
        }
        return results;

    }

    private void union(Map<String, String> roots, Map<String, Double> weights,
                       String a, String b, Double quotient) {
        // 把 a 的 root 节点的根值从它自己改成 b 点的 root 节点
        String rootOfA = this.find(roots, weights, a);
        String rootOfB = this.find(roots, weights, b);
        if (rootOfA.equals(rootOfB)) {
            return;
        }

        roots.put(a, rootOfB);

        // weight[a] = a / rootOfA
        // weight[b] = b / rootOfB
        // quotient = a / b
        // new weight[a] = a / rootOfB = (a / b)  * (b / rootOfB) = a / rootOfB
//        weights.put(a, quotient * weights.get(b));


        // 其他原本锚定 rootOfA 的元素的 weight 怎么更新？
        // 不可能一次性全算好，
        // 只能算好 weight[ rootOfA ] 作为一个锚定 rootOfA 元素们的一个基准汇率，
        // 然后所有锚定 rootOfA 元素的 weight 准确值，放到 find 方法里更新，
        // 这样主函数求 x y 的 root 元素时就不能通过 roots 直接查，而是得用 find 方法

        // new weight[rootOfA] = rootOfA / rootOfB = (a / b) * (b / rootOfB) / (a / rootOfA)
        weights.put(rootOfA, quotient * weights.get(rootOfB) / weights.get(rootOfA));
    }

    private String find(Map<String, String> roots, Map<String, Double> weights, String b) {
        String parent = roots.get(b);
        while (true) {
            String grandParent = roots.get(parent);
            if (!grandParent.equals(parent)) {
                parent = grandParent;
            } else {
                break;
            }
        }

        // 延迟更新 b 的 weight
        // new weight[b] = old weight[b] * weight[root of b]
        weights.put(b, weights.get(b) * weights.get(parent));

        return parent;
    }


}
