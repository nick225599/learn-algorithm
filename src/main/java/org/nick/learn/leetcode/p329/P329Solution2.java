package org.nick.learn.leetcode.p329;

public class P329Solution2 {

    // 官方题解的双指针法
    // 比我写的简洁多了......
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/is-subsequence/solutions/346539/pan-duan-zi-xu-lie-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
