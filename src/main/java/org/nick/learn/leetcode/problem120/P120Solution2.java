package org.nick.learn.leetcode.problem120;

import java.util.List;

/**
 * 力扣 120. 三角形最小路径和
 * @see <a href="https://leetcode.cn/problems/triangle/description/">力扣 120. 三角形最小路径和</a>
 */
public class P120Solution2 {

    /**
     * 动态规划，官方题解
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        // Q: 为啥不是 int[] f = new int[triangle.getLast().size()] ？
        // A: 第 n 层的元素个数刚好是 n 个，所以数学性质相等的

        f[0] = triangle.getFirst().getFirst();

        for (int i = 1; i < n; ++i) {

            // 和 Solution1 写法一样的，只是把边界条件的处理放到了第二个循坏外层
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] = f[0] + triangle.get(i).getFirst();

        }

        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }

        return minTotal;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/triangle/solutions/329143/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {

    }
}
