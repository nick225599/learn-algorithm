package org.nick.learn.leetcode.p52;

import java.util.HashSet;
import java.util.Set;


public class P52Solution3 {

    Set<Integer> columns;
    Set<Integer> diagonals1;
    Set<Integer> diagonals2;
    int n;


    // 作者：力扣官方题解
    // 链接：https://leetcode.cn/problems/n-queens-ii/solutions/449388/nhuang-hou-ii-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int totalNQueens(int n) {
        this.columns = new HashSet<>();
        this.diagonals1 = new HashSet<>();
        this.diagonals2 = new HashSet<>();
        this.n = n;
        return backtrack(0);
    }

    public int backtrack(int row) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i; // 不用担心越界
            if (diagonals1.contains(diagonal1)) { // 不是判断当前列？
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            count += backtrack(row + 1);
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
        return count;
    }


}
