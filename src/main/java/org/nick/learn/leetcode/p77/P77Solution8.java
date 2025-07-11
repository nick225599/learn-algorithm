package org.nick.learn.leetcode.p77;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  作者：力扣官方题解
 *  链接：https://leetcode.cn/problems/combinations/solutions/405094/zu-he-by-leetcode-solution/
 *  来源：力扣（LeetCode）
 *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@Slf4j
public class P77Solution8 {

    // 33ms 击败10%
    // 98.77MB
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmpList;
        for (int i = (1 << k) - 1; i < (1 << n); i++) {
            if(Integer.bitCount(i) != k){
                continue;
            }

            tmpList = new ArrayList<>(k);

            // 用位运算解决
            int tmpI = i;
            int tmp = 1;
            while(tmpI > 0){
                if((tmpI & 1) == 1){
                    tmpList.add(tmp);
                }
                tmpI >>= 1;
                tmp++;
            }

            ans.add(tmpList);
        }
        return ans;
    }


}
