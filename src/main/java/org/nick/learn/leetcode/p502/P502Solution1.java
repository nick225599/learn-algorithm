package org.nick.learn.leetcode.p502;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P502Solution1 {

    /**
     * @param k Pick a list of at most k distinct projects
     * @param w Initially, you have w capital.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 题目没有说 profits 是有序的，也没有说 capital 是有序的
        // 1. 根据 profits 构建一个大顶堆
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (project1, project2) -> project2[0] - project1[0]
        );
        for (int i = 0; i < profits.length; i++) {
            maxHeap.add(new int[]{profits[i], capital[i]});
        }

        int curk = 0;

        // 2. 每次从堆里取一个项目出来，判断能不能做，能做就做，不能做先放一边
        List<int[]> buff = new ArrayList<>(profits.length);
        while (!maxHeap.isEmpty()) {

            int[] project = maxHeap.poll();

            // 启动资金不够做不了，先放到一边
            if (project[1] > w) {
                buff.add(project);
                continue;
            }

            // 干项目
            w += profits[0];
            curk++;

            if (curk == k) {
                break;
            }

            // 3. 做完这个项目后，把这个项目完整踢出堆，把之前放到一边的项目重新放回堆
            maxHeap.addAll(buff);
            buff.clear();

        }


        // 4. 再从堆里取出下一个项目，直至项目数达到 k
        // 5. 计算累计收益并输出
        // ？ 放到一边的项目用什么数据结构存放？继续用堆？汉诺塔？？？？
        //TODO 先用 List 实现一遍，然后再看下官方题解

        return w;
    }
}
