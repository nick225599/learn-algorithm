package org.nick.learn.leetcode.problem200;

import lombok.AllArgsConstructor;

public class Solution3 {

    /**
     * 并查集
     */
    public int numIslands(char[][] grid) {
        //TODO nick 20250415 怎么运用并查集？
        // 初始化整个并查集
        // 遍历每个元素，如果是 1 判断每个元素是否要和前面 N 个岛屿进行合并？
        // 最后怎么统计岛屿数量？

//        DisjointSetUnion200 dsuInstance = new DisjointSetUnion200(grid);
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    grid[i][j] = 'x';
//                    bfs(grid, i, j);
//                    sum++;
//                }
//            }
//        }

        //TODO nick 20250411 采用并查集的方式实现
        return -1;
    }

    @AllArgsConstructor
    private static class DSUNode {
        private  int x;
        private  int y;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DSUNode node)) {
                return false;
            }
            return node.x == this.x && node.y == this.y;
        }
    }

    static class DisjointSetUnion200 {
        private DSUNode[][] parent;

        public DSUNode getNode(int x, int y){
            return parent[x][y];
        }

        public boolean isRoot(int x, int y){
            DSUNode node =  getNode(x,y);
            return node.x == x && node.y == y;
        }

        public DisjointSetUnion200(char[][] gird) {
            parent = new DSUNode[gird.length][gird[0].length];
            for (int i = 0; i < gird.length; i++) {
                for (int j = 0; j < gird[0].length; j++) {
                    parent[i][j] = new DSUNode(i, j);
                }
            }
        }

        // 查某个元素所在集合的代表元素
        public DSUNode find(DSUNode element) {
            // 优化： 路径压缩，将沿路所有节点直接挂到代表元素上
            // 采用双迭代版本，不递归，也不额外使用内存空间
            DSUNode curNode = element;
            while(!isRoot(curNode.x, curNode.y)){
                curNode = getNode(curNode.x, curNode.y);
            }
            DSUNode root = curNode;

            // 路径优化
            curNode = element;
            while(!isRoot(curNode.x, curNode.y)){
                curNode = parent[curNode.x][curNode.y];
                parent[curNode.x][curNode.y] = root;
            }

            return root;
        }

        // 判断元素 A 和元素 B 是否是同一个集合中的元素
        public boolean isSameSet(DSUNode elementA, DSUNode elementB) {
            return find(elementA).equals(find(elementB));
        }

        // 合并元素 A 与元素 B 所在的集合
        public void unionSet(DSUNode elementA, DSUNode elementB) {
            DSUNode rootA = find(elementA);
            DSUNode rootB = find(elementB);
            if(!rootA.equals(rootB)){
                rootA.x = rootB.x;
                rootA.y = rootB.y;
            }
            //TODO 优化: 小挂大
        }
    }

}
