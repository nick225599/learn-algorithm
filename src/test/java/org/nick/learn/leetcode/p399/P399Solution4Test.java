package org.nick.learn.leetcode.p399;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P399Solution4Test {

    P399Solution4 solution = new P399Solution4();

    @Test
    void test() {
        double[][] graph = new double[255][255];
        // 假设有四个变量（节点）：A, B, C, D，已知以下除法关系（边权重）：
        //

        graph['a']['b'] = 2;
        graph['b']['a'] = 1.0 / 2;


        graph['b']['c'] = 3;
        graph['c']['b'] = 1.0 / 3;

        //C/D = 4.0 → C→D 权重为 4.0，D→C 权重为 0.25
        graph['c']['d'] = 4;
        graph['d']['c'] = 1.0 / 4;

        //目标：计算 A/D 的比值（正确结果应为 2.0 × 3.0 × 4.0 = 24.0）。
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                for (int z = 0; z < 4; z++) {
                    char charX = (char) ('a' + x);
                    char charY = (char) ('a' + y);
                    char charZ = (char) ('a' + z);
                    double xy = graph[charX][charY];
                    double yz = graph[charY][charZ];
                    if (xy > 0 & yz > 0) {
                        double xz = xy * yz;
                        graph[charX][charZ] = xz;
                    }
                }
            }
        }

        //A/B = 2.0 → A→B 权重为 2.0，B→A 权重为 0.5
        //B/C = 3.0 → B→C 权重为 3.0，C→B 权重为 1/3
        //C/D = 4.0 → C→D 权重为 4.0，D→C 权重为 0.25
        assertEquals(1, graph['a']['a']);
        assertEquals(2, graph['a']['b']);
        assertEquals(6, graph['a']['c']);
        assertEquals(24, graph['a']['d']);

        assertEquals(1.0 / 2, graph['b']['a']);
        assertEquals(1, graph['b']['b']);
        assertEquals(3, graph['b']['c']);
        assertEquals(12, graph['b']['d']);

        assertEquals(1.0 / 6, graph['c']['a']);
        assertEquals(1.0 / 3, graph['c']['b']);
        assertEquals(1, graph['c']['c']);
        assertEquals(4, graph['c']['d']);

        assertEquals(1.0 / 24, graph['d']['a']);
        assertEquals(1.0 / 12, graph['d']['b']);
        assertEquals(1.0 / 4, graph['d']['c']);
        assertEquals(1, graph['d']['d']);

    }

    @Test
    void testCalcEquation() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "c")); // 2
        equations.add(List.of("b", "e")); // 3
        equations.add(List.of("c", "d")); // 1/2
        equations.add(List.of("e", "d")); // 5
        double[] values = new double[]{2.0, 3.0, 0.5, 5.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "b")); // a->c * c->d * d->e * e->b
        // 2 * 1/2 * 1/5 * 1/3

        //TODO nick 看下为啥漏了
        double[] result = solution.calcEquation(equations, values, queries);
        double d = 2 * (1.0 / 2) * (1.0 / 5) * (1.0 / 3);
        System.out.println("实际 a / b = " + result[0]);
        System.out.println("预期 a / b = " + d);

    }
}