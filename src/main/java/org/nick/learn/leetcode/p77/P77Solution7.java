package org.nick.learn.leetcode.p77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  作者：力扣官方题解
 *  链接：https://leetcode.cn/problems/combinations/solutions/405094/zu-he-by-leetcode-solution/
 *  来源：力扣（LeetCode）
 *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class P77Solution7 {

    // 官方题解二
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>(k);
        List<List<Integer>> ans = new LinkedList<>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }


}
