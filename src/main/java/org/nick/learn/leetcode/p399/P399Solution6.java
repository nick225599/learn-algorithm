package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class P399Solution6 {

    // 带权并查集
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int nvars = 0;
            Map<String, Integer> variables = new HashMap<String, Integer>();

            int n = equations.size();
            for (int i = 0; i < n; i++) {
                if (!variables.containsKey(equations.get(i).get(0))) {
                    variables.put(equations.get(i).get(0), nvars++);
                }
                if (!variables.containsKey(equations.get(i).get(1))) {
                    variables.put(equations.get(i).get(1), nvars++);
                }
            }
            int[] f = new int[nvars];
            double[] w = new double[nvars];
            Arrays.fill(w, 1.0);
            for (int i = 0; i < nvars; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i++) {
                int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
                merge(f, w, va, vb, values[i]);
            }
            int queriesCount = queries.size();
            double[] ret = new double[queriesCount];
            for (int i = 0; i < queriesCount; i++) {
                List<String> query = queries.get(i);
                double result = -1.0;
                if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                    int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                    int fa = findf(f, w, ia), fb = findf(f, w, ib);
                    if (fa == fb) {
                        result = w[ia] / w[ib];
                    }
                }
                ret[i] = result;
            }
            return ret;
        }

        public void merge(int[] f, double[] w, int x, int y, double val) {
            int fx = findf(f, w, x);
            int fy = findf(f, w, y);
            f[fx] = fy;
            w[fx] = val * w[y] / w[x];
        }

        public int findf(int[] f, double[] w, int x) {
            if (f[x] != x) {
                int father = findf(f, w, f[x]);
                w[x] = w[x] * w[f[x]]; // 惰性计算  路径压缩 太难懂了

                f[x] = father;
            }
            return f[x];
        }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/evaluate-division/solutions/548585/chu-fa-qiu-zhi-by-leetcode-solution-8nxb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
