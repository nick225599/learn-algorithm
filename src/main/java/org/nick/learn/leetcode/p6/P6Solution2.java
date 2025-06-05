package org.nick.learn.leetcode.p6;

public class P6Solution2 {

    // 代码写得真简洁......
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int t = numRows * 2 - 2;
        for (int i = 0; i < numRows; ++i) { // 枚举矩阵的行
            for (int j = 0; j + i < n; j += t) { // 枚举每个周期的起始下标
                ans.append(s.charAt(j + i)); // 当前周期的第一个字符
                if (0 < i && i < numRows - 1 && j + t - i < n) {
                    ans.append(s.charAt(j + t - i));// 当前周期的第二个字符
                }
            }
        }
        return ans.toString();

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/zigzag-conversion/solutions/1298127/z-zi-xing-bian-huan-by-leetcode-solution-4n3u/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
