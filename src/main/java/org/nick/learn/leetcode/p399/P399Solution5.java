package org.nick.learn.leetcode.p399;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class P399Solution5 {

    // 带权并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> str2int = new HashMap<>();
        int count = 0;
        for (List<String> equation : equations) {
            String start = equation.getFirst();
            if(!str2int.containsKey(start)){
                str2int.put(start, count++);
            }
            String end = equation.getLast();
            if(!str2int.containsKey(end)){
                str2int.put(end, count++);
            }
        }

        int[] parents = new int[count]; // 并查集
        double[] weights = new double[count]; // 并查集的权重

        // 初始化并查集
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            weights[i] = 1;
        }

        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String x = equation.getFirst();
            String y = equation.getLast();
            int xIndex = str2int.get(x);
            int yIndex = str2int.get(y);
            double weightOfXY = values[i];
                this.union(parents, weights, xIndex, yIndex, weightOfXY);
        }





        return null;

    }

    private void union(int[] parents, double[] weights, int xIndex, int yIndex, double weightOfXY) {
        if(xIndex == yIndex){
            return;
        }

        int rootOfX = find(parents, xIndex);
        int rootOfY = find(parents, yIndex);

        if(rootOfX == rootOfY){
            return;
        }

        parents[rootOfY] = rootOfX;
        //TODO  先计算 rootOfX 到 rootOfY 的倍率
        //TODO  再算 x 到 rootOfY 的倍率
        //TODO 无法提前更新其他跟 X 同根同源的其他节点的权重了......只能在查询的时候更新了

        // n 个元素 怎么想都会有 n^2 个权重啊
        // 要么查询的时候现算？ 那不就跟 bfs dfs 一样了么？
        // 先用并查集判断连通性？ 然后用二位数组来返回权重？ 那跟带权图没啥区别了啊？？
        // Q: 怎么给它带权？
        // A: weights[] 存储阶段对应根节点的权重

    }

    private int find(int[] parents, int xIndex) {
        int rootOfX = parents[xIndex];
        while(rootOfX != xIndex){
            xIndex = rootOfX;
            rootOfX = parents[xIndex];
        }
        return rootOfX;
    }

}
