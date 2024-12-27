package org.nick.learn.leetcode.problems427;

/**
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/construct-quad-tree/solutions/1449809/jian-li-si-cha-shu-by-leetcode-solution-gcru/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SolutionLeetCodeA {

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(grid[r0][c0] == 1, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(grid, r0,            c0,            (r0 + r1) / 2,  (c0 + c1) / 2),
                dfs(grid, r0,            (c0 + c1) / 2, (r0 + r1) / 2,  c1),
                dfs(grid, (r0 + r1) / 2, c0,            r1,             (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1,             c1)
        );
        return ret;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
        SolutionLeetCodeA solution = new SolutionLeetCodeA();
        Node root = solution.construct(grid);
        System.out.println(root);
    }
}
