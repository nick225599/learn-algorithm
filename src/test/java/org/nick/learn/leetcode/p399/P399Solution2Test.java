package org.nick.learn.leetcode.p399;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P399Solution2Test {
    P399Solution2 solution = new P399Solution2();


    @Test
    void calcEquation() {
        // List<List<String>> equations,
        List<List<String>> equations = new ArrayList<>(2);
        double[] values = new double[2];
        List<String> equation;
        int i = 0;

        equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");
        equations.add(equation);
        values[i++] = 2;


        equation = new ArrayList<>();
        equation.add("b");
        equation.add("c");
        equations.add(equation);
        values[i++] = 3;

        // [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]


        List<List<String>> queries = new ArrayList<>();
        List<String> query;

        query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);


        query = new ArrayList<>();
        query.add("b");
        query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("e");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x");
        query.add("x");
        queries.add(query);




        double[] d = solution.calcEquation(equations, values, queries);
        assertEquals(6, d[0]);
        assertEquals(0.5, d[1]);
        assertEquals(-1, d[2]);
        assertEquals(1, d[3]);
        assertEquals(-1, d[4]);
    }
}