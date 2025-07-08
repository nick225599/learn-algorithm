package org.nick.learn.leetcode.p433;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P433Solution1 {

    static class Node{
        public String gene;
        public int stepCount;

        public Node(String gene, int stepCount) {
            this.gene = gene;
            this.stepCount = stepCount;
        }
    }

    // BFS
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>(10);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startGene, 0));
        visited.add(startGene);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 从 bank 里找跟 cur 差距为 1 的合法基因
            // 题中 0 <= bank.length <= 10，比较小，如果比较大
            // 则需要根据 cur.gene 变化 1 个基因位，得到 3 * 8 = 24 种可能的值，然后去 bank hashtable 里看是否存在
            for (String next : bank) {
                if(visited.contains(next)){
                    continue;
                }
                if (diff1(cur.gene, next)) {
                    if (next.equals(endGene)) {
                        return cur.stepCount + 1;
                    }
                    queue.add(new Node(next, cur.stepCount + 1));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    private boolean diff1(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (cur.charAt(i) != next.charAt(i)) {
                diff++;
                if (diff > 1) {
                    break;
                }
            }
        }
        return diff == 1;
    }
}
