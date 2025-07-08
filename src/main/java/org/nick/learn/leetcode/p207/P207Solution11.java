package org.nick.learn.leetcode.p207;

/**
 * 总结
 *
 * P207Solution11 性能更高的核心原因是：
 *
 * 自定义链表结构替代了 ArrayList，避免了动态扩容和方法调用的开销。
 * 布尔数组标记状态比整数数组更简洁高效。
 * 直接返回结果的递归方式减少了额外的条件判断。
 *
 * 这种优化思路与前一题类似 —— 通过更底层的数据结构（数组 + 指针）替代 Java 的集合框架，减少抽象层带来的开销。
 * 在算法竞赛中，这种 "手动实现数据结构" 的做法很常见，可以显著提升性能。
 */
public class P207Solution11 {

    static class Node {
        Node next;
        int val;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 1ms 方案
    public boolean canFinish(int numCourses, int[][] prerequisites) {

//        使用自定义链表节点 Node 构建邻接表，每个节点直接存储后继节点的引用。
//        添加边时只需创建新节点并修改指针，无需扩容或复制数组。
//        遍历邻接表时直接通过 node.next 访问下一个节点，无需方法调用，效率更高。
        Node[] corses = new Node[numCourses];
        for (int[] pre : prerequisites) {
            corses[pre[0]] = new Node(pre[1], corses[pre[0]]);
        }
        // 关键点：自定义链表比 ArrayList 更轻量级，避免了动态扩容和方法调用的开销。

        // 使用两个布尔数组 visited 和 finished，直接标记节点状态。
        // 状态检查和更新更简洁（如 if (visited[i]) return false），减少了条件判断的复杂度。
        // 关键点：布尔数组比整数数组更节省空间，且状态判断更直接。
        boolean[] finished = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(corses, finished, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Node[] corses, boolean[] finished, boolean[] visited, int i) {
        if (finished[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        Node node = corses[i];
        while (node != null) {
            if (!dfs(corses, finished, visited, node.val))
                return false;
            node = node.next;
        }
        finished[i] = true;
        return true;
    }

}
