package org.nick.learn.leetcode.p52;

import java.util.HashSet;
import java.util.Set;


public class P52Solution3 {

    Set<Integer> columns;
    Set<Integer> diagonals1;
    Set<Integer> diagonals2;
    int n;
    int result;


    // 作者：力扣官方题解
    // 链接：https://leetcode.cn/problems/n-queens-ii/solutions/449388/nhuang-hou-ii-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // 6ms 击败9%
    public int totalNQueens(int n) {
        this.columns = new HashSet<>();
        this.diagonals1 = new HashSet<>();
        this.diagonals2 = new HashSet<>();
        this.n = n;
        this.result = 0;
        backtrack(0);
        return this.result;
    }

    public void backtrack(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            // 斜线方向为从左上到右下方时，
            // 同一条斜线上的每个位置满足行下标与列下标之差相等
            // 这点太巧妙了
            int diagonal1 = row - i; // 不用担心越界
            if (diagonals1.contains(diagonal1)) { // 不是判断当前列？
                continue;
            }
            // 斜线方向为从左上到右下方时，
            // 同一条斜线上的每个位置满足行下标与列下标之和相等
            // 这点太巧妙了
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            this.backtrack(row + 1);
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }


}
