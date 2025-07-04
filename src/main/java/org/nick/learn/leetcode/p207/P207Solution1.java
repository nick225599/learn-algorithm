package org.nick.learn.leetcode.p207;

public class P207Solution1 {
    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node head = null;
        Node tail = null;
        for(int[] prerequisite: prerequisites){
            int cur = prerequisite[0];
            int require = prerequisite[1];
            if(null == head) {
                head = tail = new Node(require);
                head.next = tail;
                tail.pre = head;

            }
            Node tmp = new Node(cur);
            tail.next = tmp;
            tmp.pre = tail;
            tail = tmp;
        }

        //  怎么开新 head ？

        // 这个数据结构怪怪的
        // 并查集也不行
        // 应该用邻接表，有点忘了怎么代码实现的了，查下文档。

        return false;

    }
}
