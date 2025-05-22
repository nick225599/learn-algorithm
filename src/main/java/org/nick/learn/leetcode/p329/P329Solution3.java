package org.nick.learn.leetcode.p329;

public class P329Solution3 {

    // 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    //
    // 进阶：
    // 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
    // 你需要依次检查它们是否为 T 的子序列。
    //
    // 在这种情况下，你会怎样改变代码？
    public boolean isSubsequence(String s, String t) {
        // nick 准备看 dp 解法
        // 没啥好看的 预处理 t，t * 26 个字母来快速判断 s 是不是 t 的子字符串
        // 实际文本不可能只有 26 个字母，实际 s 也不可能 10 亿
        // 更像是为了评估时间复杂度来出题

        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/is-subsequence/solutions/346539/pan-duan-zi-xu-lie-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


}
