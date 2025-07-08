package org.nick.learn.leetcode.p210;

public class P210Solution8 {
    // 1ms 解法
    public int[] findOrder(int n, int[][] prerequisites) {
        int m = prerequisites.length;

//        P210Solution8 的数组模拟邻接表：
//        使用三个数组模拟链表结构的邻接表：
//        head[i]：存储节点 i 的邻接表表头（指向第一个后继节点的索引）。
//        next[cnt]：存储第 cnt 个链表节点的下一个节点索引（模拟链表的 next 指针）。
//        to[cnt]：存储第 cnt 个链表节点指向的后继节点（即课程 i 的后继课程）。
//        构建图时，通过指针操作（修改数组值）添加节点，无需扩容，时间复杂度为 O (m)（m 是边数）。
//        遍历邻接表时，通过数组索引直接访问，无需对象方法调用和边界检查，操作更接近底层，速度更快。
        int[] head = new int[n];
        int[] next = new int[m + 1];
        int[] to = new int[m + 1];

        int[] indegress = new int[n];
        int cnt = 1;

        for (int[] prerequisite : prerequisites) {
            next[cnt] = head[prerequisite[1]];
            head[prerequisite[1]] = cnt;
            to[cnt++] = prerequisite[0];
            indegress[prerequisite[0]]++;
        }

//        P210Solution8 的数组模拟队列：
//        使用固定大小的数组 queue，通过两个指针 l（队头）和 r（队尾）标记队列范围，入队 / 出队仅需移动指针（r++ 或 l++），操作是纯数组索引访问，无额外开销。
//        无需创建链表节点，内存访问更连续，缓存利用率更高（数组在内存中是连续存储的，而链表节点分散存储，容易导致缓存失效）。
        int l = 0, r = 0;
        int[] queue = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }

        while (l < r) {
            for (int ei = head[queue[l++]]; ei > 0; ei = next[ei]) {
                if (--indegress[to[ei]] == 0) {
                    queue[r++] = to[ei];
                }
            }
        }

        return r == n ? queue : new int[0];
    }
}
