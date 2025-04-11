package org.nick.learn.leetcode.problem200;

public class Solution3 {

    /**
     * 并查集
     */
    public int numIslands(char[][] grid) {
        //TODO sunchuansheng 20250411 采用并查集的方式实现
        return -1;
    }

    // 查某个元素所在集合的代表元素
    public Object find(Object element){
        // 优化： 路径压缩，将沿路所有节点直接挂到代表元素上
        // 采用双迭代版本，不递归，也不额外使用内存空间
        return null;
    }

    // 判断元素 A 和元素 B 是否是同一个集合中的元素
    public boolean isSameSet(Object elementA, Object elementB){
        return false;
    }

    // 合并元素 A 与元素 B 所在的集合
    public void unionSet(Object elementA, Object elementB){
        // 优化: 小挂大
    }

    public static void main(String[] args) {
        int[] parent = new int[]{-1, -1, -1, -1, -1};

        // 0-1
        parent[0] = 1;

        // 2-1
        parent[2] = 1;

        // 3-4
        parent[3] = 4;

        // 1-3 -> 1-4
        parent[1] = 4;



        // 2-4
        // 2-5

    }


}
