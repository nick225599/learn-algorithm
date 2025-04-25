package org.nick.learn.leetcode.p427;

/**
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/construct-quad-tree/solutions/1449809/jian-li-si-cha-shu-by-leetcode-solution-gcru/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SolutionLeetCodeB {

    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(grid, pre, 0, 0, n, n);
    }

    public Node dfs(int[][] grid, int[][] pre, int r0, int c0, int r1, int c1) {
        int total = getSum(pre, r0, c0, r1, c1);
        if (total == 0) {
            return new Node(false, true);
        } else if (total == (r1 - r0) * (c1 - c0)) {
            return new Node(true, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(grid, pre, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, pre, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, pre, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, pre, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

    /**
     * 方法二：递归 + 二维前缀和优化
     * 思路与算法
     * <p>
     * 我们可以对方法一中暴力判定某一部分是否均为 0 或 1 的代码进行优化。
     * <p>
     * 具体地，当某一部分均为 0 时，它的和为 0；某一部分均为 1 时，它的和为这一部分的面积大小。
     * 因此我们可以使用二维前缀和（参考「304. 二维区域和检索 - 矩阵不可变」）进行优化。
     * 我们可以与处理出数组 grid 的二维前缀和，这样一来，
     * 当我们需要判定某一部分是否均为 0 或 1 时，
     * 可以在 O(1) 的时间内得到这一部分的和，从而快速地进行判断。
     */
    public int getSum(int[][] pre, int r0, int c0, int r1, int c1) {
        return pre[r1][c1] - pre[r1][c0] - pre[r0][c1] + pre[r0][c0];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
        SolutionLeetCodeB solution = new SolutionLeetCodeB();
        Node root = solution.construct(grid);
        System.out.println(root);
    }
}
